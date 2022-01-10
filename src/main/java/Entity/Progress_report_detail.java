package Entity;

public class Progress_report_detail {
    private Integer id;

    private String studentNo;

    private String planSectionType;

    private String courseNo;

    private String remark;

    private Integer reportId;

    public Progress_report_detail(Integer id, String studentNo, String planSectionType, String courseNo, String remark, Integer reportId) {
        this.id = id;
        this.studentNo = studentNo;
        this.planSectionType = planSectionType;
        this.courseNo = courseNo;
        this.remark = remark;
        this.reportId = reportId;
    }

    public Progress_report_detail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getPlanSectionType() {
        return planSectionType;
    }

    public void setPlanSectionType(String planSectionType) {
        this.planSectionType = planSectionType == null ? null : planSectionType.trim();
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo == null ? null : courseNo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}