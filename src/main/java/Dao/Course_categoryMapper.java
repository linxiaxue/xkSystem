package Dao;

import Entity.Course_category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Course_categoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course_category record);

    int insertSelective(Course_category record);

    Course_category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course_category record);

    int updateByPrimaryKey(Course_category record);

    @Select("select * from course_category where plan_section_id = #{plan_section_id}")
    List<Course_category> selectByPlanSectionId(int planSectionId);
}