package Dao;

import Entity.Plan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    @Select("select * from plan where major = #{major}")
    List<Plan> selectByMajor(String major);
}