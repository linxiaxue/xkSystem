package Dao;

import Entity.Course_category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Course_categoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course_category record);

    int insertSelective(Course_category record);

    Course_category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course_category record);

    int updateByPrimaryKey(Course_category record);

    @Delete("delete from course_category")
    int deleteAll();

    List<Course_category> selectByPlanSectionId(int planSectionId);
}