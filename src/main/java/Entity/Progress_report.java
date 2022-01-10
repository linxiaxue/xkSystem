package Entity;

public class Progress_report {
    private Integer id;

    private String studentNo;

    private Integer planId;

    private String planSectionType;

    private Integer planThreshold;

    private Integer actualcredit;

    private Integer unit;

    private String remark;

    private Integer actualnumber;

    public Progress_report(Integer id, String studentNo, Integer planId, String planSectionType, Integer planThreshold, Integer actualcredit, Integer unit, String remark, Integer actualnumber) {
        this.id = id;
        this.studentNo = studentNo;
        this.planId = planId;
        this.planSectionType = planSectionType;
        this.planThreshold = planThreshold;
        this.actualcredit = actualcredit;
        this.unit = unit;
        this.remark = remark;
        this.actualnumber = actualnumber;
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

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
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

    public Integer getActualcredit() {
        return actualcredit;
    }

    public void setActualcredit(Integer actualcredit) {
        this.actualcredit = actualcredit;
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

    public Integer getActualnumber() {
        return actualnumber;
    }

    public void setActualnumber(Integer actualnumber) {
        this.actualnumber = actualnumber;
    }
}