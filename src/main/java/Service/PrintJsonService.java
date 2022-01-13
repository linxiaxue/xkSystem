package Service;

import Dao.Progress_reportMapper;

import Entity.*;
import Dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.*;

import javax.annotation.Resource;

import java.util.List;

public class PrintJsonService {
    @Resource
    StudentMapper studentMapper;

    static String overflowRecord="";
    static int total_overflow=0;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void PrimaryPrintJson(String student_no)throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByStudentNo(student_no);
            Student student=students.get(0);
            Progress_reportMapper progress_reportMapper=openSession.getMapper(Progress_reportMapper.class);
            List<Progress_report> progress_report=progress_reportMapper.selectByStudentNo(student_no);

            String output="{" +
                    "\"学号\":\""+student_no+"\"," +
                    "\"学生名\":\""+student.getName()+"\"," +
                    "\"专业\":\""+student.getMajor()+"\"," +
                    "\"进度汇总\":";
            //"}";
            String huizong="[";
            String detail="\"进度详情\":{";

            Progress_report progress_report1=FindReport(progress_report,"Basic Compulsory");
            Progress_report progress_report2=FindReport(progress_report,"Major Compulsory");
            huizong+=CalHuizong(progress_report1,progress_report2,"必修的基础课与专业基础课");
            detail+=CalDetail(openSession,progress_report1,progress_report2,"必修的基础课与专业基础课");

            progress_report1=FindReport(progress_report,"Major Elective");
            huizong+=CalHuizong(progress_report1,"专业选修课");
            detail+=CalDetail(openSession,progress_report1,"专业选修课");

            progress_report1=FindReport(progress_report,"Module 1");
            huizong+=CalHuizong(progress_report1,"模块课 1");
            detail+=CalDetail(openSession,progress_report1,"模块课 1");

            progress_report1=FindReport(progress_report,"Module 2");
            huizong+=CalHuizong(progress_report1,"模块课 2");
            detail+=CalDetail(openSession,progress_report1,"模块课 2");


            progress_report1=FindReport(progress_report,"Other Elective");
            huizong+=CalHuizong(progress_report1,"任意选修课");
            detail+=CalDetail(openSession,progress_report1,"任意选修课");


            huizong=huizong.substring(0,huizong.length()-1);
            huizong+="],";
            detail=detail.substring(0,detail.length()-1);
            detail+="}}";
            output+=huizong+detail;
            System.out.println(formatToJson(output));
            createJsonFile(formatToJson(output),"result/","基础功能result");



        } finally {
            openSession.close();
        }
    }

    public void AdvancedPrintJson(String student_no)throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByStudentNo(student_no);
            Student student=students.get(0);
            Progress_reportMapper progress_reportMapper=openSession.getMapper(Progress_reportMapper.class);
            List<Progress_report> progress_report=progress_reportMapper.selectByStudentNo(student_no);

            String output="{" +
                    "\"学号\":\""+student_no+"\"," +
                    "\"学生名\":\""+student.getName()+"\"," +
                    "\"专业\":\""+student.getMajor()+"\"," +
                    "\"方向\":\""+"A"+"\"," +
                    "\"进度汇总\":";
            //"}";
            String huizong="[";
            String detail="\"进度详情\":{";

            Progress_report progress_report1=FindReport(progress_report,"Basic Compulsory");
            Progress_report progress_report2=FindReport(progress_report,"Major Compulsory");
            huizong+=CalHuizong(progress_report1,progress_report2,"必修的基础课与专业基础课");
            detail+=CalDetail(openSession,progress_report1,progress_report2,"必修的基础课与专业基础课");

            progress_report1=FindReport(progress_report,"Major Elective");
            huizong+=CalHuizong(progress_report1,"专业选修课");
            detail+=CalDetail(openSession,progress_report1,"专业选修课");

            progress_report1=FindReport(progress_report,"Module 1");
            huizong+=CalHuizong(progress_report1,"模块课 1");
            detail+=CalDetail(openSession,progress_report1,"模块课 1");

            progress_report1=FindReport(progress_report,"Module 2");
            huizong+=CalHuizong(progress_report1,"模块课 2");
            detail+=CalDetail(openSession,progress_report1,"模块课 2");


            progress_report1=FindReport(progress_report,"Direction A");
            huizong+=CalHuizong(progress_report1,"方向课 A");
            detail+=CalDetail(openSession,progress_report1,"方向课 A");

            progress_report1=FindReport(progress_report,"Other Elective");
            huizong+=CalHuizong(progress_report1,"任意选修课");
            detail+=CalDetail(openSession,progress_report1,"任意选修课");


            huizong=huizong.substring(0,huizong.length()-1);
            huizong+="],";
            detail=detail.substring(0,detail.length()-1);
            detail+="}}";
            output+=huizong+detail;
            System.out.println(formatToJson(output));
            createJsonFile(formatToJson(output),"result/","增强功能result");



        } finally {
            openSession.close();
        }
    }
    public static Progress_report FindReport(List<Progress_report> progress_report,String ClassType){
        for (int i=0;i<progress_report.size();i++){

            Progress_report progress_report1=progress_report.get(i);
            if(progress_report1.getPlanSectionType().equals(ClassType)){
                return progress_report1;
            }
        }
        return null;
    };

    public static String CalHuizong(Progress_report progress_report1,String ChinessClassType){
        String huizong="";
        huizong+="{" +
                "\"课程类型\":\""+ChinessClassType+"\"," +
                "\"已修学分\":\""+progress_report1.getActualcredit()+"\"," +
                "\"已修课程数量\":\""+progress_report1.getActualnumber()+"\"," +
                "\"要求学分/课程数量\":\""+progress_report1.getPlanThreshold()+"\"," +
                "\"进度情况\":\""+(int)(Float.parseFloat(progress_report1.getRemark())*100)+"%\"" +
                "},";
        return huizong;
    }
    public static String CalHuizong(Progress_report progress_report1,Progress_report progress_report2,String ChinessClassType){
        String huizong="";
        int credits=progress_report1.getActualcredit()+progress_report2.getActualcredit();
        int numbers=progress_report1.getActualnumber()+progress_report2.getActualnumber();
        int total=progress_report1.getPlanThreshold()+progress_report2.getPlanThreshold();
        int jindu=credits*100/total;
        huizong+="{" +
                "\"课程类型\":\""+ChinessClassType+"\"," +
                "\"已修学分\":\""+credits+"\"," +
                "\"已修课程数量\":\""+numbers+"\"," +
                "\"要求学分/课程数量\":\""+total+"\"," +
                "\"进度情况\":\""+jindu+"%\"" +
                "},";

        return huizong;
    }

    public static String CalDetail(SqlSession openSession,Progress_report progress_report1,String ChinessClassType){
        String detail="";

        Progress_report_detailMapper progress_report_detailMapper=openSession.getMapper(Progress_report_detailMapper.class);
        List<Progress_report_detail> progress_report_details=progress_report_detailMapper.selectByReportId(progress_report1.getId());

        String classdetail="\""+ChinessClassType+"\":[";
        CourseMapper courseMapper=openSession.getMapper(CourseMapper.class);
        //System.out.println("details数量:"+progress_report_details.size());
        classdetail+=CalClassDetail(courseMapper,progress_report_details);

        int xuqiu=progress_report1.getPlanThreshold();
        int current=0;
        if(ChinessClassType.equals("任意选修课")){
            classdetail+=overflowRecord;
            current=progress_report1.getActualcredit();
            int lack=xuqiu-current>0?xuqiu-current:0;

            classdetail+="{" +
                    "\"总结\":\"要求"+progress_report1.getPlanThreshold()+"学分，缺少"+lack+"学分，超出"+total_overflow+"学分。\"," +
                    "\"备注\":\""+(int)(Float.parseFloat(progress_report1.getRemark())*100)+"%\""+
                    "}";
            overflowRecord="";
            total_overflow=0;


        }
        else {
            if(progress_report1.getUnit()==0){
                current=progress_report1.getActualcredit();
                int lack=xuqiu-current>0?xuqiu-current:0;

                classdetail+="{" +
                        "\"总结\":\"要求"+progress_report1.getPlanThreshold()+"学分，缺少"+lack +"学分。\"," +
                        "\"备注\":\""+(int)(Float.parseFloat(progress_report1.getRemark())*100)+"%\""+
                        "}";
                int overflow=current-xuqiu>0?current-xuqiu:0;
                total_overflow+=overflow;
                overflowRecord+="{" +
                        "\"课程\":\""+ChinessClassType+"超出学分\"," +
                        "\"学分\":\""+overflow+"\"," +
                        "\"备注\":\""+"null"+"\"" +
                        "},";
            }
            else {
                current=progress_report1.getActualnumber();
                int lack=xuqiu-current>0?xuqiu-current:0;
                classdetail+="{" +
                        "\"总结\":\"要求"+progress_report1.getPlanThreshold()+"门课，缺少"+lack +"门课。\"," +
                        "\"备注\":\""+(int)(Float.parseFloat(progress_report1.getRemark())*100)+"%\""+
                        "}";
                int overflow=current-xuqiu>0?current-xuqiu:0;
                overflow*=2;
                total_overflow+=overflow;
                overflowRecord+="{" +
                        "\"课程\":\""+ChinessClassType+"超出学分\"," +
                        "\"学分\":\""+overflow+"\"," +
                        "\"备注\":\""+"null"+"\"" +
                        "},";
            }

        }



        classdetail+="],";

        detail+=classdetail;
        return detail;
    }
    public static String CalClassDetail(CourseMapper courseMapper, List<Progress_report_detail> progress_report_details){
        String classdetail="";
        for (int j=0;j<progress_report_details.size();j++){
            Progress_report_detail progress_report_detail=progress_report_details.get(j);
            String s=progress_report_detail.getCourseNo();
            //System.out.println("NO:"+s);
            List<Course> courses=courseMapper.selectByCourseNo(s);
            //System.out.println("courses数量:"+courses.size());
            for(int x=0;x<courses.size();x++){
                Course course=courses.get(x);
                String ret="null";
                if(!progress_report_detail.getRemark().equals("")){
                    ret=progress_report_detail.getRemark();
                }
                classdetail+="{" +
                        "\"课程\":\""+course.getCourseNo()+"-"+course.getName()+"\"," +
                        "\"学分\":\""+course.getCredit()+"\"," +
                        "\"备注\":\""+ret+"\"" +
                        "},";
            }

        }
        return classdetail;
    }

    public static String CalDetail(SqlSession openSession,Progress_report progress_report1,Progress_report progress_report2,String ChinessClassType){
        String detail="";

        Progress_report_detailMapper progress_report_detailMapper=openSession.getMapper(Progress_report_detailMapper.class);
        List<Progress_report_detail> progress_report_details=progress_report_detailMapper.selectByReportId(progress_report1.getId());

        String classdetail="\""+ChinessClassType+"\":[";
        CourseMapper courseMapper=openSession.getMapper(CourseMapper.class);
        //System.out.println("details数量:"+progress_report_details.size());
        classdetail+=CalClassDetail(courseMapper,progress_report_details);
        progress_report_details=progress_report_detailMapper.selectByReportId(progress_report2.getId());
        classdetail+=CalClassDetail(courseMapper,progress_report_details);


        int credits=progress_report1.getActualcredit()+progress_report2.getActualcredit();
        int numbers=progress_report1.getActualnumber()+progress_report2.getActualnumber();
        int total=progress_report1.getPlanThreshold()+progress_report2.getPlanThreshold();
        int jindu=credits*100/total;

        int xuqiu=progress_report1.getPlanThreshold()+progress_report2.getPlanThreshold();
        int current=0;
        if(progress_report1.getUnit()==0){
            current=progress_report1.getActualcredit()+progress_report2.getActualcredit();
            int lack=xuqiu-current>0?xuqiu-current:0;
            classdetail+="{" +
                    "\"总结\":\"要求"+xuqiu+"学分，缺少"+lack +"学分。\"," +
                    "\"备注\":\""+jindu+"%\""+
                    "}";
            int overflow=current-xuqiu>0?current-xuqiu:0;
            total_overflow+=overflow;
            overflowRecord+="{" +
                    "\"课程\":\""+ChinessClassType+"超出学分\"," +
                    "\"学分\":\""+overflow+"\"," +
                    "\"备注\":\""+"null"+"\"" +
                    "},";
        }
        else {
            jindu=numbers*100/total;
            current=progress_report1.getActualnumber()+progress_report2.getActualnumber();
            int lack=xuqiu-current>0?xuqiu-current:0;
            classdetail+="{" +
                    "\"总结\":\"要求"+total+"门课，缺少"+lack +"门课。\"," +
                    "\"备注\":\""+jindu+"%\""+
                    "}";
            int overflow=current-xuqiu>0?current-xuqiu:0;
            overflow*=2;
            total_overflow+=overflow;
            overflowRecord+="{" +
                    "\"课程\":\""+ChinessClassType+"超出学分\"," +
                    "\"学分\":\""+overflow+"\"," +
                    "\"备注\":\""+"null"+"\"," +
                    "},";
        }



        classdetail+="],";

        detail+=classdetail;
        return detail;
    }

    public static String formatToJson(String region) {
        int level = 0;
        StringBuffer preBuffer = new StringBuffer();
        for (int i = 0; i < region.length(); i++) {
            char c = region.charAt(i);
            if (level > 0 && '\n' == preBuffer.charAt(preBuffer.length() - 1)) {
                preBuffer.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    preBuffer.append(c + "\n");
                    level++;
                    break;
                case ',':
                    preBuffer.append(c + "\n");
                    break;
                case '}':
                case ']':
                    preBuffer.append("\n");
                    level--;
                    preBuffer.append(getLevelStr(level));
                    preBuffer.append(c);
                    break;
                default:
                    preBuffer.append(c);
                    break;
            }
        }

        return String.valueOf(preBuffer);

    }

    private static String getLevelStr(int level) {
        StringBuffer lb = new StringBuffer();
        for (int levelTmp = 0; levelTmp < level; levelTmp++) {
            lb.append("\t");
        }
        return String.valueOf(lb);
    }

    public static boolean createJsonFile(String jsonString, String filePath, String fileName) {
        // 标记文件生成是否成功
        boolean flag = true;

        // 拼接文件完整路径
        String fullPath = filePath + File.separator + fileName + ".json";

        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();





            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        // 返回是否成功的标记
        return flag;
    }

}
