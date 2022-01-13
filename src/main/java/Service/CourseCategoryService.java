package Service;

import Dao.CourseMapper;
import Dao.Course_categoryMapper;
import Entity.Course;
import Entity.Course_category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CourseCategoryService {
    @Resource
    Course_categoryMapper course_categoryMapper;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Course_category add(Course_category course) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Course_categoryMapper course_categoryMapper = openSession.getMapper(Course_categoryMapper.class);
            course_categoryMapper.insert(course);
            openSession.commit();
            //System.out.println("新增id：" + course.getId());
            return course;
        } finally {
            openSession.close();
        }
    }

    public List<Course_category> queryByPlanSectionId(int planSectionId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Course_categoryMapper course_categoryMapper = openSession.getMapper(Course_categoryMapper.class);
            List<Course_category> courses = course_categoryMapper.selectByPlanSectionId(planSectionId);
            //System.out.println("查询到的条目数:" + courses.size());
            return courses;
        } finally {
            openSession.close();
        }
    }

    public List<Course_category> queryByPlanSectionIdAndCourseNo(int planSectionId,String courseNo) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Course_categoryMapper course_categoryMapper = openSession.getMapper(Course_categoryMapper.class);
            List<Course_category> courses = course_categoryMapper.selectByPlanSectionIdAndCourseNo(planSectionId,courseNo);
            if (courses != null && courses.size() != 0) {
                //System.out.println("查询到的条目数:" + courses.size());
                return courses;
            }else {
                return null;
            }
        } finally {
            openSession.close();
        }
    }


    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Course_categoryMapper course_categoryMapper = openSession.getMapper(Course_categoryMapper.class);
            course_categoryMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }
}
