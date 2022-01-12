package Service;

import Dao.PlanMapper;
import Dao.Progress_report_detailMapper;
import Entity.Course;
import Entity.Progress_report;
import Entity.Progress_report_detail;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ProgressReportDetailService {
    private PlanSectionService planSectionService = new PlanSectionService();

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void saveReportDetail(Course course, String studentNo, Progress_report progressReport, String remark) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Progress_report_detail progressReportDetail = new Progress_report_detail();
            progressReportDetail.setCourseNo(course.getCourseNo());
            progressReportDetail.setPlanSectionType(progressReport.getPlanSectionType());
            progressReportDetail.setReportId(progressReport.getId());
            progressReportDetail.setStudentNo(studentNo);
            progressReportDetail.setRemark(remark);
            Progress_report_detailMapper progressReportDetailMapper = openSession.getMapper(Progress_report_detailMapper.class);
            progressReportDetailMapper.insert(progressReportDetail);
            openSession.commit();
        }finally {
            openSession.close();
        }

    }

    public Progress_report_detail queryReportDetail(String courseNo,  int reportId) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Progress_report_detailMapper progressReportDetailMapper = openSession.getMapper(Progress_report_detailMapper.class);
            List<Progress_report_detail> list = progressReportDetailMapper.queryReportDetailByCourseNoAndReportId(courseNo,reportId);
            if (list != null & list.size() != 0){
                return list.get(0);
            }
            openSession.commit();
        }finally {
            openSession.close();
        }
        return null;

    }

    public void deleteAll() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Progress_report_detailMapper progressReportDetailMapper = openSession.getMapper(Progress_report_detailMapper.class);
            progressReportDetailMapper.deleteAll();
            openSession.commit();

        } finally {
            openSession.close();
        }
    }

    public void deleteById(Progress_report_detail progress_report_detail) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Progress_report_detailMapper progressReportDetailMapper = openSession.getMapper(Progress_report_detailMapper.class);
            progressReportDetailMapper.deleteByPrimaryKey(progress_report_detail.getId());
            openSession.commit();

        } finally {
            openSession.close();
        }
    }
}
