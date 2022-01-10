package Service;

import Dao.Progress_reportMapper;

import Entity.*;
import Dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PrintJsonService {
    @Resource
    StudentMapper studentMapper;

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
            for (int i=0;i<progress_report.size();i++){
                Progress_report progress_report1=progress_report.get(i);
                huizong+="{" +
                        "\"课程类型\":\""+progress_report1.getPlanSectionType()+"\"," +
                        "\"已修学分\":\""+progress_report1.getActualcredit()+"\"," +
                        "\"已修课程数量\":\""+progress_report1.getActualnumber()+"\"," +
                        "\"要求学分/课程数量\":"+progress_report1.getPlanThreshold()+"\"," +
                        "\"进度情况\":"+Float.parseFloat(progress_report1.getRemark())*100+"%\"" +
                        "},";
                Progress_report_detailMapper progress_report_detailMapper=openSession.getMapper(Progress_report_detailMapper.class);
                List<Progress_report_detail> progress_report_details=progress_report_detailMapper.selectByReportId(progress_report1.getId());

                String classdetail="\""+progress_report1.getPlanSectionType()+"\":[";
                CourseMapper courseMapper=openSession.getMapper(CourseMapper.class);
                //System.out.println("details数量:"+progress_report_details.size());
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
                                "\"备注\":\""+ret+"\"," +
                                "},";
                    }

                }

                int xuqiu=progress_report1.getPlanThreshold();
                int current=0;
                if(progress_report1.getUnit()==0){
                    current=progress_report1.getActualcredit();
                    int lack=xuqiu-current>0?xuqiu-current:0;
                    classdetail+="{" +
                            "\"总结\":\"要求"+progress_report1.getPlanThreshold()+"学分，缺少"+lack +"学分。\"," +
                            "\"备注\":\""+Float.parseFloat(progress_report1.getRemark())*100+"%\""+
                            "}";
                }
                else {
                    current=progress_report1.getActualnumber();
                    int lack=xuqiu-current>0?xuqiu-current:0;
                    classdetail+="{" +
                            "\"总结\":\"要求"+progress_report1.getPlanThreshold()+"门课，缺少"+lack +"门课。\"," +
                            "\"备注\":\""+Float.parseFloat(progress_report1.getRemark())*100+"%\""+
                            "}";
                }



                classdetail+="],";

                detail+=classdetail;
            }
            huizong=huizong.substring(0,huizong.length()-1);
            huizong+="],";
            detail=detail.substring(0,detail.length()-1);
            detail+="}}";
            output+=huizong+detail;
            System.out.println(formatToJson(output));



        } finally {
            openSession.close();
        }
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

}
