package Entity;

public class Plan {
    private Integer id;

    private String major;

    private String direction;

    public Plan(Integer id, String major, String direction) {
        this.id = id;
        this.major = major;
        this.direction = direction;
    }

    public Plan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }
}