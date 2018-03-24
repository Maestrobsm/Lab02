package entry;

import id.CreatorId;

import java.sql.Date;
import java.util.ArrayList;


public class Employee extends CreatorId {
    private String name;
    private Integer salary;
    private String date;
    private Long deptNo;
    private Long idObj;
    private Long idObjTyp;
    private Long idSal;
    private Long idDat;
    private Long idDept;
    private ArrayList<Long> listDeptId = new ArrayList<Long>();


    public Employee(String name, Integer salary, String date, Long deptNo) {
        this.name = name;
        this.salary = salary;
        this.date = date;
        this.deptNo = deptNo;
        idObj = getObjectId();
        idObjTyp = getTypeId();
        idSal = getAttribId();
        idDat = getAttribId();
        idDept = getAttribId();
    }

    public Employee(String name, Integer salary, String date, Long deptNO, Long id) {
        this.name = name;
        this.salary = salary;
        this.date = date;
        this.deptNo = deptNO;
        this.idObj = id;
        idObjTyp = getTypeId();
        idSal = getAttribId();
        idDat = getAttribId();
        idDept = getAttribId();
    }

    public Employee() {
        idObj = getObjectId();
        idObjTyp = getTypeId();
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

    public Long getIdObj() {
        return idObj;
    }

    public void setIdObj(Long idObj) {
        this.idObj = idObj;
    }

    public Long getIdObjTyp() {
        return idObjTyp;
    }

    public void setIdObjTyp(Long idObjTyp) {
        this.idObjTyp = idObjTyp;
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

    public ArrayList<Long> getListDeptId() {
        return listDeptId;
    }

    public void setListDeptId(ArrayList<Long> listDeptId) {
        this.listDeptId = listDeptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", date='" + date + '\'' +
                ", deptNo='" + deptNo + '\'' +
                ", Id='" + idObj + '\'' +
                '}';
    }
}
