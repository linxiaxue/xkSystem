package Dao;

import Entity.Student_course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Student_courseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student_course record);

    int insertSelective(Student_course record);

    Student_course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student_course record);

    int updateByPrimaryKey(Student_course record);

    @Select("select * from student_course where student_no = #{student_no}")
    List<Student_course> selectByStudentNo(String studentNo);

    @Select("select * from student_course where course_no = #{course_no}")
    List<Student_course> selectByCourseNo(String courseNo);
}