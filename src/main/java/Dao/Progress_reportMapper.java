package Dao;

import Entity.Progress_report;
import Entity.Progress_reportExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Progress_reportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Progress_report record);

    int insertSelective(Progress_report record);

    List<Progress_report> selectByExample(Progress_reportExample example);

    Progress_report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Progress_report record);

    int updateByPrimaryKey(Progress_report record);

    List<Progress_report> selectByStudentNo(String studentNo);

    @Delete("delete from progress_report")
    int deleteAll();

    List<Progress_report> selectByPlanIdAndStudentNo(@Param("planId")int planId, @Param("studentNo")String studentNo);

    List<Progress_report> selectByPlanIdAndStudentNoAndSectionType(@Param("planId")int planId,@Param("studentNo")String studentNo,@Param("planSectionType")String planSectionType);

}