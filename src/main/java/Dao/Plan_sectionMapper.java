package Dao;

import Entity.Plan_section;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Plan_sectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan_section record);

    int insertSelective(Plan_section record);

    Plan_section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan_section record);

    int updateByPrimaryKey(Plan_section record);

    @Select("select from plan_section where plan_id = #{planId}")
    List<Plan_section> selectByPlanId(int planId);
}