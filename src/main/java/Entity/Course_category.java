package Entity;

public class Course_category {
    private Integer id;

    private Integer planSectionId;

    private String courseNo;

    public Course_category(Integer id, Integer planSectionId, String courseNo) {
        this.id = id;
        this.planSectionId = planSectionId;
        this.courseNo = courseNo;
    }

    public Course_category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanSectionId() {
        return planSectionId;
    }

    public void setPlanSectionId(Integer planSectionId) {
        this.planSectionId = planSectionId;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }
}