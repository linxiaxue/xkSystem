package Service;

import Dao.*;
import Entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressReportService {
    private PlanService planService = new PlanService();
    private PlanSectionService planSectionService = new PlanSectionService();
    private ProgressReportDetailService progressReportDetailService = new ProgressReportDetailService();
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private CourseCategoryService courseCategoryService = new CourseCategoryService();
    private Map<String,Progress_report> progressReportMap = new HashMap<String, Progress_report>();

    public void init(String studentNo,Plan_section plan_section) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Progress_reportMapper progressReportMapper = openSession.getMapper(Progress_reportMapper.class);
        List<Progress_report> progressReports = progressReportMapper.selectByPlanIdAndStudentNoAndSectionType(plan_section.getPlanId(),studentNo,plan_section.getPlanSectionType());
        Progress_report progress_report = new Progress_report();
        if (progressReports.size() != 0){
            progress_report = progressReports.get(0);
        }else {
            progress_report.setPlanSectionType(plan_section.getPlanSectionType());
            progress_report.setPlanThreshold(plan_section.getPlanThreshold());
            progress_report.setUnit(plan_section.getUnit());
            progress_report.setPlanId(plan_section.getPlanId());
            progress_report.setStudentNo(studentNo);
            progress_report.setActualnumber(0);
            progress_report.setActualcredit(0);
            progressReportMapper.insert(progress_report);
            openSession.commit();
        }
        progressReportMap.put(plan_section.getPlanSectionType(),progress_report);
    }


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void updateReportByStudentNo(String studentNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Progress_reportMapper progressReportMapper = openSession.getMapper(Progress_reportMapper.class);
        Student student = studentService.queryStudentByStudentNo(studentNo);
        Plan plan = planService.queryPlanByMajor(student.getMajor());
        List<Plan_section> list = planSectionService.queryByPlanId(plan.getId());
        for (Plan_section plan_section : list){
            init(studentNo,plan_section);
        }
        countByCourse(studentNo,plan.getId());
        for (Plan_section plan_section : list){
            if (!plan_section.getPlanSectionType().equals("Other Elective")) {
                countByPlanSection(plan_section, student,progressReportMap.get(plan_section.getPlanSectionType()));
            }
        }
        progressReportMapper.updateByPrimaryKey(progressReportMap.get("Other Elective"));
        openSession.commit();

    }

    private void countByCourse(String studentNo,int planId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Student_courseMapper student_courseMapper = openSession.getMapper(Student_courseMapper.class);
        List<Student_course> student_courses = student_courseMapper.selectByStudentNo(studentNo);
        for (Student_course student_course : student_courses){
            Plan_section plan_section = planSectionService.queryByCourseAndPlanId(planId,student_course.getCourseNo());
            Course course = courseService.queryCourseByCourseNo(student_course.getCourseNo());
            if(plan_section != null){
                addCourse(progressReportMap.get(plan_section.getPlanSectionType()),course,"");
            }else {
                addCourse(progressReportMap.get("Other Elective"),course,"");
            }
        }

    }



    private void countByPlanSection(Plan_section planSection, Student student, Progress_report progress_report) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Progress_reportMapper progressReportMapper = openSession.getMapper(Progress_reportMapper.class);

        try {

            List<Course_category> planCourses = courseCategoryService.queryByPlanSectionId(planSection.getId());
            for (Course_category course_category : planCourses){
                String courseNo = course_category.getCourseNo();
                Course course = courseService.queryCourseByCourseNo(courseNo);
                Student_courseMapper student_courseMapper = openSession.getMapper(Student_courseMapper.class);
                List<Student_course> student_courses = student_courseMapper.selectByCourseNoAndStudentNo(courseNo,student.getStudentNo());
                if (student_courses.size() == 0){
                    if (course.getExchangeNo() != null && !course.getExchangeNo().equals("")){
                        List<Student_course> exStudent_courses = student_courseMapper.selectByCourseNoAndStudentNo(course.getExchangeNo(),student.getStudentNo());
                        if (exStudent_courses.size() != 0 && exStudent_courses!= null) {
                            Course exCourse = courseService.queryCourseByCourseNo(course.getExchangeNo());
                            addCourse(progress_report, course, exCourse.getCourseNo() + exCourse.getName());
                            deleteCourse(progressReportMap.get("Other Elective"),exCourse);
                        }
                    }
                }
            }
            progressReportMapper.updateByPrimaryKey(progress_report);
            openSession.commit();

        }finally {
            openSession.close();
        }
    }


    private void addCourse(Progress_report progressReport, Course course, String remark) throws IOException {
        progressReport.setActualcredit(progressReport.getActualcredit() + course.getCredit());
        progressReport.setActualnumber(progressReport.getActualnumber() + 1);
        if (progressReport.getActualnumber() >= progressReport.getPlanThreshold() || progressReport.getActualcredit() >= progressReport.getPlanThreshold()){
            progressReport.setRemark("1.0");
        }else {
            if (progressReport.getUnit() == 0) {
                double progress = (double) progressReport.getActualcredit() / (double) progressReport.getPlanThreshold();
                progressReport.setRemark(String.format("%.2f", progress));
            } else {
                double progress = (double) progressReport.getActualnumber() / (double) progressReport.getPlanThreshold();
                progressReport.setRemark(String.format("%.2f", progress));
            }
        }
        progressReportDetailService.saveReportDetail(course, progressReport.getStudentNo(), progressReport, remark);


    }

    private void deleteCourse(Progress_report progressReport, Course course) throws IOException {
        Progress_report_detail progress_report_detail = progressReportDetailService.queryReportDetail(course.getCourseNo(),progressReport.getId());
        progressReportDetailService.deleteById(progress_report_detail);
        progressReport.setActualcredit(progressReport.getActualcredit() - course.getCredit());
        progressReport.setActualnumber(progressReport.getActualnumber() - 1);
        if (progressReport.getActualnumber() >= progressReport.getPlanThreshold() || progressReport.getActualcredit() >= progressReport.getPlanThreshold()){
            progressReport.setRemark("1.0");
        }else {
            if (progressReport.getUnit() == 0) {
                double progress = (double) progressReport.getActualcredit() / (double) progressReport.getPlanThreshold();
                progressReport.setRemark(String.format("%.2f", progress));
            } else {
                double progress = (double) progressReport.getActualnumber() / (double) progressReport.getPlanThreshold();
                progressReport.setRemark(String.format("%.2f", progress));
            }
        }

    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Progress_reportMapper progressReportDetailMapper = openSession.getMapper(Progress_reportMapper.class);
            progressReportDetailMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }


}
