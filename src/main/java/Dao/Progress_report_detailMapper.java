package Dao;

import Entity.Progress_report_detail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.*;

public interface Progress_report_detailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Progress_report_detail record);

    int insertSelective(Progress_report_detail record);

    Progress_report_detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Progress_report_detail record);

    int updateByPrimaryKey(Progress_report_detail record);

    @Delete("delete from progress_report_detail")
    int deleteAll();

    List<Progress_report_detail> selectByReportId(Integer reportId);

    List<Progress_report_detail> queryReportDetailByCourseNoAndReportId(@Param("courseNo")String courseNo,@Param("reportId")int reportId);
}
