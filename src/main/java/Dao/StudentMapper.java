package Dao;

import Entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    @Select("select * from student where name = #{name}")
    List<Student> selectByName(String name);

    @Select("select * from student where student_no = #{student_no}")
    List<Student> selectByStudentNo(String studentNo);
}