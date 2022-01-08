package Entity;

public class Progress_report {
    private Integer id;

    private String studentNo;

    private String planSectionType;

    private Integer planThreshold;

    private Integer actual;

    private Integer unit;

    private String remark;

    public Progress_report(Integer id, String studentNo, String planSectionType, Integer planThreshold, Integer actual, Integer unit, String remark) {
        this.id = id;
        this.studentNo = studentNo;
        this.planSectionType = planSectionType;
        this.planThreshold = planThreshold;
        this.actual = actual;
        this.unit = unit;
        this.remark = remark;
    }

    public Progress_report() {
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

    public Integer getPlanThreshold() {
        return planThreshold;
    }

    public void setPlanThreshold(Integer planThreshold) {
        this.planThreshold = planThreshold;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}