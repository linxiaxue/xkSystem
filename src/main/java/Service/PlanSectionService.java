package Service;

import Dao.PlanMapper;
import Dao.Plan_sectionMapper;
import Entity.Course_category;
import Entity.Plan;
import Entity.Plan_section;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PlanSectionService {
    @Resource
    Plan_sectionMapper plan_sectionMapper;
    private CourseCategoryService courseCategoryService = new CourseCategoryService();

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Plan_section add(Plan_section planSection) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Plan_sectionMapper plan_sectionMapper = openSession.getMapper(Plan_sectionMapper.class);
            plan_sectionMapper.insert(planSection);
            openSession.commit();
            //System.out.println("新增修读计划模块id：" + planSection.getId());
            return planSection;
        } finally {
            openSession.close();
        }
    }

    public List<Plan_section> queryByPlanId(int planId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Plan_sectionMapper plan_sectionMapper = openSession.getMapper(Plan_sectionMapper.class);
            List<Plan_section> plans = plan_sectionMapper.selectByPlanId(planId);
            //System.out.println("查询到的条目数:" + plans.size());
            return plans;
        } finally {
            openSession.close();
        }
    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Plan_sectionMapper plan_sectionMapper = openSession.getMapper(Plan_sectionMapper.class);
            plan_sectionMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }

    public List<Plan_section> queryAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            Plan_sectionMapper plan_sectionMapper = openSession.getMapper(Plan_sectionMapper.class);
            List<Plan_section> plans = plan_sectionMapper.selectAll();
            //System.out.println("查询到的条目数:" + plans.size());
            return plans;
        } finally {
            openSession.close();
        }
    }

    public Plan_section queryByCourseAndPlanId(int planId,String courseNo) throws IOException {
        List<Plan_section> plan_sections = queryByPlanId(planId);
        for (Plan_section plan_section : plan_sections){
            List<Course_category> courses = courseCategoryService.queryByPlanSectionIdAndCourseNo(plan_section.getId(),courseNo);
            if (courses != null){
                return plan_section;
            }
        }
        return null;
    }
}
