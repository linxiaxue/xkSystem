package Dao;

import Entity.Progress_report;

public interface Progress_reportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Progress_report record);

    int insertSelective(Progress_report record);

    Progress_report selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Progress_report record);

    int updateByPrimaryKey(Progress_report record);
}