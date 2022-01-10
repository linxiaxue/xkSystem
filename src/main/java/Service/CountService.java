package Service;

import Dao.*;
import Dto.ProgressReportQueryDto;
import Entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CountService {
    private StudentService studentService = new StudentService();
    private PlanSectionService planSectionService = new PlanSectionService();
    private CourseService courseService = new CourseService();

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    public void countByStudentNo(String studentNo) throws IOException {
        Student student = studentService.queryStudentByStudentNo(studentNo);
        Plan plan = getPlanByStudentNo(student);
        List<Plan_section> list = planSectionService.queryByPlanId(plan.getId());
        for (Plan_section plan_section : list){
            countPlanSection(plan_section,student);
        }
    }

    public Plan getPlanByStudentNo(Student student) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Plan plan = new Plan();

        try {
                String major = student.getMajor();
                PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
                List<Plan> plans = planMapper.selectByMajor(major);
                if (plans.size() == 1){
                    plan = plans.get(0);
                }

        } finally {
            openSession.close();
        }
        return plan;
    }

    public void countPlanSection(Plan_section plan_section, Student student) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        Progress_report progress_report = new Progress_report();

        int actualCredit = 0;
        int actualNumber = 0;
        try {
            Progress_reportMapper progress_reportMapper = openSession.getMapper(Progress_reportMapper.class);
            List<Progress_report> progress_reports = progress_reportMapper.selectByPlanIdAndStudentNoAndSectionType(plan_section.getPlanId(),student.getStudentNo(),plan_section.getPlanSectionType());
            if (progress_reports.size() != 0){
                progress_report = progress_reports.get(0);
            }else {
                progress_report.setPlanSectionType(plan_section.getPlanSectionType());
                progress_report.setPlanThreshold(plan_section.getPlanThreshold());
                progress_report.setUnit(plan_section.getUnit());
                progress_report.setPlanId(plan_section.getPlanId());
                progress_report.setStudentNo(student.getStudentNo());
                progress_reportMapper.insert(progress_report);
                openSession.commit();
            }
            Course_categoryMapper course_categoryMapper = openSession.getMapper(Course_categoryMapper.class);
            List<Course_category> planCourses = course_categoryMapper.selectByPlanSectionId(plan_section.getId());
            for (Course_category course_category : planCourses){
                String courseNo = course_category.getCourseNo();
                Course course = courseService.queryCourseByCourseNo(courseNo);
                Student_courseMapper student_courseMapper = openSession.getMapper(Student_courseMapper.class);
                List<Student_course> student_courses = student_courseMapper.selectByCourseNoAndStudentNo(courseNo,student.getStudentNo());
                if (student_courses.size() != 0){
                    actualNumber ++;
                    actualCredit += course.getCredit();
                    saveReportDetail(course,student.getStudentNo(),progress_report,"");
                }else{
                    if (course.getExchangeNo() != null && !course.getExchangeNo().equals("")){
                        Course exCourse = courseService.queryCourseByCourseNo(course.getExchangeNo());
                        actualNumber ++;
                        actualCredit += exCourse.getCredit();
                        saveReportDetail(exCourse,student.getStudentNo(),progress_report,"交流");
                    }
                }
            }
            if (progress_report.getUnit() == 0){
                progress_report.setActual(actualCredit);
                double progress = (double)actualCredit/(double)progress_report.getPlanThreshold();
                progress_report.setRemark(String.format("%.2f", progress));
            }else {
                progress_report.setActual(actualNumber);
                double progress = (double)actualNumber/(double)progress_report.getPlanThreshold();
                progress_report.setRemark(String.format("%.2f", progress));
            }
            progress_reportMapper.updateByPrimaryKey(progress_report);
            openSession.commit();


        }finally {
            openSession.close();
        }
    }

    private void saveReportDetail(Course course,String studentNo,Progress_report progress_report,String remark) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Progress_report_detail progress_report_detail = new Progress_report_detail();
            progress_report_detail.setCourseNo(course.getCourseNo());
            progress_report_detail.setPlanSectionType(progress_report.getPlanSectionType());
            progress_report_detail.setReportId(progress_report.getId());
            progress_report_detail.setStudentNo(studentNo);
            progress_report_detail.setRemark(remark);
            Progress_report_detailMapper progress_report_detailMapper = openSession.getMapper(Progress_report_detailMapper.class);
            progress_report_detailMapper.insert(progress_report_detail);
            openSession.commit();
        }finally {
            openSession.close();
        }

    }


}
