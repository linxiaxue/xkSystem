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
        inputData.initCourse(1);
        inputData.initStudent_Course(1);
        inputData.initPlan();
        inputData.initPlanSection(1);
        inputData.initCourseCategory(1);
        ProgressReportService progressReportService = new ProgressReportService();
        progressReportService.updateReportByStudentNo("18302010993");
        PrintJsonService printJsonService=new PrintJsonService();
        printJsonService.AdvancedPrintJson("18302010993");
    }
}
