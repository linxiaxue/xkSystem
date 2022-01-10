package Dao;

import Entity.Student_course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Student_courseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student_course record);

    int insertSelective(Student_course record);

    Student_course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student_course record);

    int updateByPrimaryKey(Student_course record);

    List<Student_course> selectByStudentNo(String studentNo);

    List<Student_course> selectByCourseNo(String courseNo);

    @Delete("delete from student_course")
    int deleteAll();
}