package dao;

import entry.Employee;

import java.sql.SQLException;


public interface EmployeeDAO {

    void create(Employee employee) throws SQLException;

    Employee get(Long id) throws SQLException;

    boolean delete(Long Id) throws SQLException;

}
