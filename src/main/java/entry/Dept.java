package entry;

import id.CreatorId;

import java.util.ArrayList;

public class Dept extends CreatorId {
    private String deptName;
    private String location;
    private Long idObj;
    private Long idObjTyp;
    private Long idLoc;
    private ArrayList<Long> listEmployeeId = new ArrayList<Long>();


    public Dept(String deptName, String location) {
        this.deptName = deptName;
        this.location = location;
        idObj = getObjectId();
        idObjTyp = getTypeId();
        idLoc = getAttribId();
    }

    public Dept(String deptName, String location, Long id) {
        this.deptName = deptName;
        this.location = location;
        this.idObj = id;
    }

    public Dept() {
    }

    public ArrayList<Long> getListEmployeeId() {
        return listEmployeeId;
    }

    public void setListEmployeeId(ArrayList<Long> listEmployeeId) {
        this.listEmployeeId = listEmployeeId;
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
                ", Id=" + idObj + '\'' +
                '}';
    }
}
