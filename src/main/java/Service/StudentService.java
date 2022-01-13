package Service;

import Dao.StudentMapper;
import Entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentService {
    @Resource
    StudentMapper studentMapper;


    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Student addStudent(Student student) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            studentMapper.insert(student);
            openSession.commit();
            //System.out.println("新增学生id：" + student.getId());
            return student;
        } finally {
            openSession.close();
        }
    }

    public Student queryStudentByStudentNo(String studentNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByStudentNo(studentNo);
            //System.out.println("查询到的条目数:" + students.size());
            return students.get(0);
        } finally {
            openSession.close();
        }
    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
            studentMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }

    public void changeMajor(String studentNo,String newMajor) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = openSession.getMapper(StudentMapper.class);
        Student student = queryStudentByStudentNo(studentNo);
        student.setMajor(newMajor);
        studentMapper.updateByPrimaryKey(student);

    }
}
