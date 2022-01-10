package Dao;

import Entity.Progress_report;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Progress_reportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Progress_report record);

    int insertSelective(Progress_report record);

    Progress_report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Progress_report record);

    int updateByPrimaryKey(Progress_report record);

    List<Progress_report> selectByStudentNo(String studentNo);

    int deleteAll();
}