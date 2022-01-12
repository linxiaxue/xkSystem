package Common;

import java.sql.*;
import java.util.Scanner;

public class DBUtil {

    private static String db_url="";
    public static String db_url_front = "jdbc:mysql://localhost:3306/";
    private static String db_settings = "?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
//    private static String username = "root";
//    private static String password = "sasuke62587719";

    public static Connection getConnection () {
        Connection conn = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("连接Mysql中...");
        System.out.println("请输入数据库名：(如mysql）");
        String database = scanner.next();
        db_url = db_url_front+database+db_settings;
        System.out.println("url为："+db_url);

        System.out.println("请输入用户名：");
        String name = scanner.next();
        System.out.println("用户名为："+name);

        System.out.println("请输入密码：");
        String pwd = scanner.next();
        System.out.println("密码为："+pwd);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, name, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }


    public static void close (Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close ( PreparedStatement state) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close (ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close (Statement state) {

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}


