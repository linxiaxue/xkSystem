package Dao;

import Entity.Plan_section;

public interface Plan_sectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan_section record);

    int insertSelective(Plan_section record);

    Plan_section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan_section record);

    int updateByPrimaryKey(Plan_section record);
}