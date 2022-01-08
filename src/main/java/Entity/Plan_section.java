package Entity;

public class Plan_section {
    private Integer id;

    private Integer planId;

    private String planSectionType;

    private Integer planThreshold;

    private Integer unit;

    public Plan_section(Integer id, Integer planId, String planSectionType, Integer planThreshold, Integer unit) {
        this.id = id;
        this.planId = planId;
        this.planSectionType = planSectionType;
        this.planThreshold = planThreshold;
        this.unit = unit;
    }

    public Plan_section() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}