package Service;

import Dao.CourseMapper;
import Entity.Course;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CourseService {
    @Resource
    CourseMapper courseMapper;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Course addCourse(Course course) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            CourseMapper courseMapper = openSession.getMapper(CourseMapper.class);
            courseMapper.insert(course);
            openSession.commit();
            System.out.println("新增课程id：" + course.getId());
            return course;
        } finally {
            openSession.close();
        }
    }

    public Course queryCourseByCourseNo(String courseNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            CourseMapper courseMapper = openSession.getMapper(CourseMapper.class);
            List<Course> courses = courseMapper.selectByCourseNo(courseNo);
            System.out.println("查询到的条目数:" + courses.size());
            return courses.get(0);
        } finally {
            openSession.close();
        }
    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            CourseMapper courseMapper = openSession.getMapper(CourseMapper.class);
            courseMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }
}
