package Service;

import Entity.*;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class InputData {
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();
    private StudentCourseService studentCourseService = new StudentCourseService();
    private PlanService planService = new PlanService();
    private PlanSectionService planSectionService = new PlanSectionService();
    private CourseCategoryService courseCategoryService = new CourseCategoryService();
    //向系统中导入学生数据Students_Info.txt
    public void initStudent() throws IOException {
        //清空表中数据
        studentService.deleteAll();
        File file = new File("TestCase/增强功能/Students_Info.txt");
        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bw.readLine())!=null){
                String[] s = line.split(",");
                Student student = new Student();
                student.setStudentNo(s[0]);
                student.setName(s[1]);
                student.setMajor(s[2]);
                student = studentService.addStudent(student);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入课程数据Courses_info.txt
    public void initCourse(int mode) throws IOException {
        courseService.deleteAll();
        if(mode==0){
            File file = new File("TestCase/基础功能/Courses_Info.txt");
            try {
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = bw.readLine())!=null){
                    String[] s = line.split(",");
                    Course course = new Course();
                    course.setCourseNo(s[0]);
                    course.setName(s[1]);
                    course.setCredit(Integer.parseInt(s[2].replace(" ","")));
                    courseService.addCourse(course);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            File file = new File("TestCase/增强功能/Courses_Info.txt");
            try {
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = bw.readLine())!=null){
                    String[] s = line.split(",");
                    Course course = new Course();
                    course.setCourseNo(s[0]);
                    course.setName(s[1]);
                    course.setCredit(Integer.parseInt(s[2].replace(" ","")));
                    course.setExchangeNo(s[3].replace("none",""));
                    courseService.addCourse(course);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //按照Learning.txt将修读信息导入系统
    public void initStudent_Course(int mode) throws IOException {

        studentCourseService.deleteAll();
        String choice="";
        if(mode==0){
            choice="基础功能";
        }
        else {
            choice="增强功能";
        }
        File file = new File("TestCase/"+choice+"/Learning.txt");
        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bw.readLine())!=null){
                String[] s = line.split(",");
                Student_course student_course = new Student_course();
                student_course.setStudentNo(s[0]);
                student_course.setCourseNo(s[1]);
                student_course.setDate("2018-09");
                studentCourseService.add(student_course);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入专业名.txt
    public void initPlan() throws IOException {
        planService.deleteAll();
        File file = new File("TestCase/专业名.txt");
        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bw.readLine())!=null){
                String[] s = line.split(",");
                Plan plan = new Plan();
                plan.setMajor(s[0]);
                planService.add(plan);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入培养方案<major>.txt中的模块分类
    public void initPlanSection(int mode) throws IOException {
        planSectionService.deleteAll();
        List<Plan> plans = planService.queryAll();
        int plan_Number = plans.size();
        String choice="";
        if(mode==0){
            choice="基础功能";
        }
        else {
            choice="增强功能";
        }
        for(int i=0;i<plan_Number;i++){
            String path = "TestCase/"+choice+"/"+plans.get(i).getMajor()+".txt";
            File file = new File(path);
            try {
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = bw.readLine())!=null){
                    String s = line.substring(0,1);
                    if(s.equals("[")){
                        int start = line.indexOf("[");
                        int end = line.indexOf("]");
                        String[] str = new String[2];
                        str[0] = line.substring(start,end+1);
                        str[1] = line.substring(end+1);
                        String plan_Section_Type = str[0].substring(1,str[0].length()-1);
                        String plan_threshold = str[1];
                        int unit ;
                        if(plan_Section_Type.equals("Module 1")|plan_Section_Type.equals("Module 2")){
                            unit = 1;
                        }
                        else {
                            unit = 0;
                        }
                        Plan_section plan_section = new Plan_section();
                        plan_section.setPlanId(plans.get(i).getId());
                        plan_section.setPlanSectionType(plan_Section_Type);
                        plan_section.setPlanThreshold(Integer.parseInt(plan_threshold.replace(" ","")));
                        plan_section.setUnit(unit);
                        planSectionService.add(plan_section);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //向系统中导入培养方案<major>.txt中各模块分类所包含的课程目录
    public void initCourseCategory(int mode) throws IOException {
        courseCategoryService.deleteAll();
        List<Plan_section> plan_sections = planSectionService.queryAll();
        int plan_Number = plan_sections.size();
        String choice="";
        if(mode==0){
            choice="基础功能";
        }
        else {
            choice="增强功能";
        }
        for(int i=0;i<plan_Number;i++){
            Plan_section planSection = plan_sections.get(i);
            Plan plan = planService.queryById(planSection.getPlanId());
            String path = "TestCase/"+choice+"/"+plan.getMajor()+".txt";
            File file = new File(path);
            try{
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                String courses = null;
                while ((line = bw.readLine())!=null){
                    //如果包含plan_id对应的模块名称
                    if(line.indexOf(planSection.getPlanSectionType())!=-1){
                        while ((courses = bw.readLine())!=null && courses.indexOf("[")==-1){
                            Course_category course_category = new Course_category();
                            course_category.setCourseNo(courses);
                            course_category.setPlanSectionId(planSection.getId());
                            courseCategoryService.add(course_category);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
