package dao;

import entry.Employee;
import java.sql.SQLException;



public interface EmployeeDAO {

    boolean create(Employee employee, Integer write) throws SQLException;

    Employee get(Long id, Integer read) throws SQLException;

    boolean delete(Long Id, Integer write) throws SQLException;
}