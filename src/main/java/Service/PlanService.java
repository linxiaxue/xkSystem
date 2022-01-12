package Service;

import Dao.PlanMapper;
import Dao.StudentMapper;
import Entity.Plan;
import Entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PlanService {
    @Resource
    PlanMapper planMapper;

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public Plan add(Plan plan) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
            planMapper.insert(plan);
            openSession.commit();
            System.out.println("新增修读计划id：" + plan.getId());
            return plan;
        } finally {
            openSession.close();
        }
    }

    public Plan queryPlanByMajor(String major) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
            List<Plan> plans = planMapper.selectByMajor(major);
            if (plans != null && plans.size() != 0) {
                System.out.println("查询到的条目数:" + plans.size());
                return plans.get(0);
            }
        } finally {
            openSession.close();
        }
        return null;
    }

    public List<Plan> queryAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
            List<Plan> plans = planMapper.selectAll();
            System.out.println("查询到的条目数:" + plans.size());
            return plans;
        } finally {
            openSession.close();
        }
    }

    public Plan queryById(int id) throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
            Plan plan = planMapper.selectByPrimaryKey(id);
            return plan;
        } finally {
            openSession.close();
        }
    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            PlanMapper planMapper = openSession.getMapper(PlanMapper.class);
            planMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }
}
