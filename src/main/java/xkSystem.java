import Service.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class xkSystem {
    public static void main(String[] args) throws IOException, SQLException {
//        Demo demo = new Demo();
//        demo.selectDemo();
       run();
    }

//    public static void run() throws SQLException {
//        //连接数据库
//        Connection conn = DBUtil.getConnection();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请选择测试功能：");
//        System.out.println("基础功能：0  增强功能：1");
//        int mode = scanner.nextInt();
//        InputData.student(conn);
//        InputData.course(conn,mode);
//        InputData.student_Course(conn,mode);
//        InputData.plan(conn);
//        InputData.plan_Section(conn,mode);
//        InputData.course_category(conn,mode);
//
//    }
    public static void run() throws IOException {
        InputData inputData = new InputData();
        inputData.initStudent();
        inputData.initCourse(0);
        inputData.initStudent_Course(0);
        inputData.initPlan();
        inputData.initPlanSection(0);
        inputData.initCourseCategory(0);
        CountService countService = new CountService();
        countService.countByStudentNo("18302010993");
        PrintJsonService printJsonService=new PrintJsonService();
        printJsonService.PrimaryPrintJson("18302010993");
    }
}
