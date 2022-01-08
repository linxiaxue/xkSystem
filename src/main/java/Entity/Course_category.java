package Entity;

public class Course_category {
    private Integer id;

    private Integer planSectionId;

    private String courseId;

    public Course_category(Integer id, Integer planSectionId, String courseId) {
        this.id = id;
        this.planSectionId = planSectionId;
        this.courseId = courseId;
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

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }
}