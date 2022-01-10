package Service;

import Dao.StudentMapper;
import Dao.Student_courseMapper;
import Entity.Student_course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentCourseService {
    @Resource
    Student_courseMapper studentCourseMapper;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Student_course add(Student_course student_course) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Student_courseMapper studentCourseMapper = openSession.getMapper(Student_courseMapper.class);
            studentCourseMapper.insert(student_course);
            openSession.commit();
            System.out.println("新增id：" + student_course.getId());
            return student_course;
        } finally {
            openSession.close();
        }
    }

    public List<Student_course> queryByStudentNo(String studentNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Student_courseMapper studentCourseMapper = openSession.getMapper(Student_courseMapper.class);
            List<Student_course> student_courses = studentCourseMapper.selectByStudentNo(studentNo);
            return student_courses;
        } finally {
            openSession.close();
        }
    }

    public List<Student_course> queryByCourseNo(String courseNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Student_courseMapper studentCourseMapper = openSession.getMapper(Student_courseMapper.class);
            List<Student_course> student_courses = studentCourseMapper.selectByCourseNo(courseNo);
            return student_courses;
        } finally {
            openSession.close();
        }
    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Student_courseMapper student_courseMapper = openSession.getMapper(Student_courseMapper.class);
            student_courseMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }


}
