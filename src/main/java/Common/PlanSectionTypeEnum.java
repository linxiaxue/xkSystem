package Common;

public enum PlanSectionTypeEnum {
    BASIC_COMPULSORY("Basic Compulsory");
    private String name;

    PlanSectionTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
