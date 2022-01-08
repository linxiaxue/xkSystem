package Entity;

import java.util.Date;

public class Student_course {
    private Integer id;

    private String courseNo;

    private Integer studentNo;

    private Date date;

    public Student_course(Integer id, String courseNo, Integer studentNo, Date date) {
        this.id = id;
        this.courseNo = courseNo;
        this.studentNo = studentNo;
        this.date = date;
    }

    public Student_course() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}