package Entity;

public class Student_course {
    private Integer id;

    private String courseNo;

    private String studentNo;

    private String date;

    public Student_course(Integer id, String courseNo, String studentNo, String date) {
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

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}