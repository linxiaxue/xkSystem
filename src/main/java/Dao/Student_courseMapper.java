package Dao;

import Entity.Student_course;

public interface Student_courseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student_course record);

    int insertSelective(Student_course record);

    Student_course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student_course record);

    int updateByPrimaryKey(Student_course record);
}