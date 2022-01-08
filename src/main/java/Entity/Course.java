package Entity;

public class Course {
    private Integer id;

    private String courseNo;

    private String name;

    private Integer credit;

    private String exchangeNo;

    public Course(Integer id, String courseNo, String name, Integer credit, String exchangeNo) {
        this.id = id;
        this.courseNo = courseNo;
        this.name = name;
        this.credit = credit;
        this.exchangeNo = exchangeNo;
    }

    public Course() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getExchangeNo() {
        return exchangeNo;
    }

    public void setExchangeNo(String exchangeNo) {
        this.exchangeNo = exchangeNo == null ? null : exchangeNo.trim();
    }
}