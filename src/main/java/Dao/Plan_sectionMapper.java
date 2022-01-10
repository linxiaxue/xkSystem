package Dao;

import Entity.Plan;
import Entity.Plan_section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Plan_sectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan_section record);

    int insertSelective(Plan_section record);

    Plan_section selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan_section record);

    int updateByPrimaryKey(Plan_section record);

    List<Plan_section> selectByPlanId(int planId);

    @Delete("delete from plan_section")
    int deleteAll();

    List<Plan_section> selectAll();
}