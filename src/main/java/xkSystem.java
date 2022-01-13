import Service.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class xkSystem {
    public static void main(String[] args) throws IOException, SQLException {

       run();
    }

    public static void run() throws IOException {
        System.out.println("1. 请确定运行了xkSystem/TestCase/xksystem.sql初始化xksystem数据库（mysql）（为防止多次重复录入数据，请在每次运行前初始化\n2.请在/xkSystem/src/main/resources/conf.xml中设置您的用户名和密码");
        InputData inputData = new InputData();
        inputData.initStudent();
        System.out.println("请选择测试功能：");
        System.out.println("基础功能：0  增强功能：1");
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        System.out.print("录入数据中");
        inputData.initCourse(mode);
        System.out.print("-");
        inputData.initStudent_Course(mode);
        System.out.print("-");
        inputData.initPlan();
        System.out.print("-");
        inputData.initPlanSection(mode);
        System.out.print("-");
        inputData.initCourseCategory(mode);
        System.out.print("-");

        ProgressReportService progressReportService = new ProgressReportService();
        progressReportService.updateReportByStudentNo("18302010993");

        System.out.println("录入数据完成");
        PrintJsonService printJsonService=new PrintJsonService();
        System.out.println("输出结果");
        if(mode==0){
            printJsonService.PrimaryPrintJson("18302010993");
        }
        else {
            printJsonService.AdvancedPrintJson("18302010993");
        }

    }
}
