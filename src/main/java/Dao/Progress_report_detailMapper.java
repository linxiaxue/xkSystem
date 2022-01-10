package Dao;

import Entity.Progress_report_detail;

public interface Progress_report_detailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Progress_report_detail record);

    int insertSelective(Progress_report_detail record);

    Progress_report_detail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Progress_report_detail record);

    int updateByPrimaryKey(Progress_report_detail record);
}