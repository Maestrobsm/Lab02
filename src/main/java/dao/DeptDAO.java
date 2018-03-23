package dao;

import entry.Dept;

import java.sql.SQLException;

public interface DeptDAO {

    boolean create(Dept dept, Integer write) throws SQLException;

    Dept get(Long deptNO, Integer read) throws SQLException;

    boolean delete(Long Id, Integer write) throws SQLException;

}
