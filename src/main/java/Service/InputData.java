package Service;

import java.io.*;
import java.sql.*;
import java.util.Random;

public class InputData {
    //向系统中导入学生数据Students_Info.txt
    public static void student(Connection conn) throws SQLException {
        //清空表中数据
        PreparedStatement statement = conn.prepareStatement("truncate table student");
        statement.executeUpdate();
        File file = new File("TestCase/增强功能/Students_Info.txt");
        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bw.readLine())!=null){
                String[] s = line.split(",");
                String string = "";
                for(int i=0;i<s.length;i++){
                    string += "'"+s[i]+"'"+",";
                }
                string = string.substring(0,string.length()-1);
                System.out.println(string);
                String sql = "insert into student (student_no,name,major) values ("+string+")";
                System.out.println(sql);
                PreparedStatement state = conn.prepareStatement(sql);
                state.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入课程数据Courses_info.txt
    public static void course(Connection conn,int mode) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("truncate table course");
        statement.executeUpdate();
        if(mode==0){
            File file = new File("TestCase/基础功能/Courses_Info.txt");
            try {
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = bw.readLine())!=null){
                    String[] s = line.split(",");
                    String string = "";
                    for(int i=0;i<s.length;i++){
                        string += "'"+s[i]+"'"+",";
                    }
                    string = string.substring(0,string.length()-1);
                    System.out.println(string);
                    String sql = "insert into course (course_no,name,credit) values ("+string+")";
                    System.out.println(sql);
                    PreparedStatement state = conn.prepareStatement(sql);
                    state.executeUpdate();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
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
                    String string = "";
                    for(int i=0;i<s.length;i++){
                        string += "'"+s[i]+"'"+",";
                    }
                    string = string.substring(0,string.length()-1);
                    System.out.println(string);
                    String sql = "insert into course (course_no,name,credit,exchange_no) values ("+string+")";
                    System.out.println(sql);
                    PreparedStatement state = conn.prepareStatement(sql);
                    state.executeUpdate();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //按照Learning.txt将修读信息导入系统
    public static void student_Course(Connection conn,int mode) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("truncate table student_course");
        statement.executeUpdate();
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
                String string = "";
                for(int i=0;i<s.length;i++){
                    string += "'"+s[i]+"'"+",";
                }
                //随机生成修读时间
                Random ran = new Random();
                int year = ran.nextInt(4)+2018;
                Random random = new Random();
                int month = random.nextInt(2);
                if(month == 0){
                    month = 3;
                }
                else {
                    month = 9;
                }

                string += "'"+year+"-"+month+"-1'";
                System.out.println(string);
                String sql = "insert into student_course (student_no,course_no,date) values ("+string+")";
                System.out.println(sql);
                PreparedStatement state = conn.prepareStatement(sql);
                state.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入专业名.txt
    public static void plan(Connection conn) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("truncate table plan");
        statement.executeUpdate();
        File file = new File("TestCase/专业名.txt");
        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bw.readLine())!=null){
                String[] s = line.split(",");
                String string = "";
                for(int i=0;i<s.length;i++){
                    string += "'"+s[i]+"'"+",";
                }
                string = string.substring(0,string.length()-1);
                System.out.println(string);
                String sql = "insert into plan (major) values ("+string+")";
                System.out.println(sql);
                PreparedStatement state = conn.prepareStatement(sql);
                state.executeUpdate();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //向系统中导入培养方案<major>.txt中的模块分类
    public static void plan_Section(Connection conn,int mode) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("truncate table plan_section");
        statement.executeUpdate();
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select * from plan");
        rset.last();
        int plan_Number = rset.getRow();
        String choice="";
        if(mode==0){
            choice="基础功能";
        }
        else {
            choice="增强功能";
        }
        for(int i=1;i<=plan_Number;i++){
            ResultSet rset1 = stmt.executeQuery("select major from plan where id='"+i+"'");
            String major = null;
            while (rset1.next()){
                major = rset1.getString(1);
            }
            String path = "TestCase/"+choice+"/"+major+".txt";
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
                        String string = "'"+i+"',"+"'"+plan_Section_Type+"',"+"'"+plan_threshold+"',"+"'"+unit+"'";
                        System.out.println(string);
                        String sql = "insert into plan_section (plan_id,plan_section_type,plan_threshold,unit) values ("+string+")";
                        System.out.println(sql);
                        PreparedStatement state = conn.prepareStatement(sql);
                        state.executeUpdate();
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
    public static void course_category(Connection conn,int mode) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("truncate table course_category");
        statement.executeUpdate();

        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select * from plan_section");
        rset.last();
        int plan_Number = rset.getRow();
        String choice="";
        if(mode==0){
            choice="基础功能";
        }
        else {
            choice="增强功能";
        }
        for(int i=1;i<=plan_Number;i++){
            ResultSet resultSet = stmt.executeQuery("select plan_id,plan_section_type from plan_section where id='"+i+"'");
            String plan_Section_Type = null;
            int plan_id = 0;
            while (resultSet.next()){
                plan_Section_Type = resultSet.getString(2);
                plan_id = resultSet.getInt(1);
            }
            ResultSet rset1 = stmt.executeQuery("select major from plan where id='"+plan_id+"'");
            String major = null;
            while (rset1.next()){
                major = rset1.getString(1);
            }
            String path = "TestCase/"+choice+"/"+major+".txt";
            File file = new File(path);
            try{
                BufferedReader bw = new BufferedReader(new FileReader(file));
                String line = null;
                String courses = null;
                while ((line = bw.readLine())!=null){
                    //如果包含plan_id对应的模块名称
                    if(line.indexOf(plan_Section_Type)!=-1){
                        while ((courses = bw.readLine())!=null && courses.indexOf("[")==-1){
                            String string = "'"+i+"','"+courses+"'";
                            System.out.println(string);
                            String sql = "insert into course_category (plan_section_id,course_no) values ("+string+")";
                            System.out.println(sql);
                            PreparedStatement state = conn.prepareStatement(sql);
                            state.executeUpdate();
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
