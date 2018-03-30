package entry;

public class Employee extends Entity{
    private String name;
    private Integer salary;
    private String date;
    private Long deptNo;
    private Long idSal;
    private Long idDat;
    private Long idDept;


    public Employee(String name, Integer salary, String date, Long deptNo) {
        super();
        this.name = name;
        this.salary = salary;
        this.date = date;
        this.deptNo = deptNo;
        idSal = getAttribId();
        idDat = getAttribId();
        idDept = getAttribId();
    }

    public Employee() {
        super();
        idSal = getAttribId();
        idDat = getAttribId();
        idDept = getAttribId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public Long getIdSal() {
        return idSal;
    }

    public void setIdSal(Long idSal) {
        this.idSal = idSal;
    }

    public Long getIdDat() {
        return idDat;
    }

    public void setIdDat(Long idDat) {
        this.idDat = idDat;
    }

    public Long getIdDept() {
        return idDept;
    }

    public void setIdDept(Long idDept) {
        this.idDept = idDept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", date='" + date + '\'' +
                ", deptNo='" + deptNo + '\'' +
                ", Id='" + super.getIdObj() + '\'' +
                '}';
    }
}
