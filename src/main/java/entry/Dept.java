package entry;

public class Dept extends Entity {
    private String deptName;
    private String location;
    private Long idLoc;


    public Dept(String deptName, String location) {
        super();
        this.deptName = deptName;
        this.location = location;
        idLoc = getAttribId();
    }

    public Dept() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Long getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(Long idLoc) {
        this.idLoc = idLoc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                ", location='" + location + '\'' +
                ", Id=" + super.getIdObj() + '\'' +
                '}';
    }
}
