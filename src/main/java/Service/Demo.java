package Service;

import Dao.StudentMapper;
import Entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Demo {
    @Resource
    StudentMapper studentMapper;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    public void addStudentDemo() throws IOException {

        Student student = new Student();
        student.setMajor("test");
        student.setName("test");
        student.setStudentNo("18302010075");
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            studentMapper.insert(student);
            openSession.commit();
            System.out.println("新增学生id：" + student.getId());
        } finally {
            openSession.close();
        }
    }

    public void selectDemo() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByName("test");
            System.out.println("查询到的条目数:" + students.size());
        } finally {
            openSession.close();
        }
    }
}
