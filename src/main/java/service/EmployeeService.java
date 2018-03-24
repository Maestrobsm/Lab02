package service;

import dao.EmployeeDAO;
import entry.Employee;
import util.JDBC;

import java.sql.*;


public class EmployeeService extends JDBC implements EmployeeDAO {

    Connection connection = getConnection();

    public boolean create(Employee employee, Integer write) throws SQLException {
        boolean result = false;

        if ( write == 1) {
            PreparedStatement preparedStatement = null;

            String sqlObTyp = "INSERT INTO OBJECT_TYPES (OBJECT_TYPE_ID, NAME) VALUES(?,?)";
            String sqlOb = "INSERT INTO OBJECTS (OBJECT_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)";
            String sqlAttr = "INSERT INTO ATTRIBUTES (ATTR_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)";
            String sqlParam = "INSERT INTO PARAMS (TEXT_VALUE, NUMBER_VALUE, DATE_VALUE, ATTR_ID, OBJECT_ID) VALUES(?,?," +
                    "TO_DATE(?, 'dd/mm/yyyy'),?,?)";

            try {
                preparedStatement = connection.prepareStatement(sqlObTyp);
                preparedStatement.setLong(1, employee.getIdObjTyp());
                preparedStatement.setString(2, "EMPLOYEE");
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlOb);
                preparedStatement.setLong(1, employee.getIdObj());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlAttr);
                preparedStatement.setLong(1, employee.getIdSal());
                preparedStatement.setString(2, "SALARY");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();


                preparedStatement = connection.prepareStatement(sqlParam);
                preparedStatement.setString(1, null);
                preparedStatement.setInt(2, employee.getSalary());
                preparedStatement.setDate(3, null);
                preparedStatement.setLong(4, employee.getIdSal());
                preparedStatement.setLong(5, employee.getIdObj());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlAttr);
                preparedStatement.setLong(1, employee.getIdDat());
                preparedStatement.setString(2, "DATE");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlParam);
                preparedStatement.setString(1, null);
                preparedStatement.setNull(2, Types.NULL);
                preparedStatement.setDate(3, employee.getDate());
                preparedStatement.setLong(4, employee.getIdDat());
                preparedStatement.setLong(5, employee.getIdObj());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlAttr);
                preparedStatement.setLong(1, employee.getIdDept());
                preparedStatement.setString(2, "DEPT_NO");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlParam);
                preparedStatement.setString(1, null);
                preparedStatement.setLong(2, employee.getDeptNo());
                preparedStatement.setDate(3, null);
                preparedStatement.setLong(4, employee.getIdDept());
                preparedStatement.setLong(5, employee.getIdObj());
                result = preparedStatement.executeQuery().next();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }return result;
        }else return result;
    }

    public Employee get(Long id, Integer read) throws SQLException {
        Employee employee = new Employee();
        if (read == 1) {
            PreparedStatement preparedStatement = null;

            String qvery = "SELECT ob.NAME \"Name\", par.NUMBER_VALUE \"Salary\", par2.DATE_VALUE \"Date\"," +
                    "par1.NUMBER_VALUE \"DeptNo\", ob.OBJECT_ID \"Id\"\n" +
                    "FROM OBJECTS ob \n" +
                    "INNER JOIN OBJECT_TYPES obt ON ob.OBJECT_TYPE_ID= obt.OBJECT_TYPE_ID\n" +
                    "INNER JOIN ATTRIBUTES atr ON obt.OBJECT_TYPE_ID = atr.OBJECT_TYPE_ID and atr.NAME = 'SALARY'\n" +
                    "INNER JOIN PARAMS par ON atr.ATTR_ID = par.ATTR_ID\n" +
                    "INNER JOIN ATTRIBUTES atr1 ON obt.OBJECT_TYPE_ID = atr1.OBJECT_TYPE_ID and atr1.NAME = 'DEPT_NO'\n" +
                    "INNER JOIN PARAMS par1 ON atr1.ATTR_ID = par1.ATTR_ID\n" +
                    "INNER JOIN ATTRIBUTES atr2 ON obt.OBJECT_TYPE_ID = atr2.OBJECT_TYPE_ID and atr2.NAME = 'DATE'\n" +
                    "INNER JOIN PARAMS par2 ON atr2.ATTR_ID = par2.ATTR_ID\n" +
                    "where ob.OBJECT_ID = ?";
            try {
                preparedStatement = connection.prepareStatement(qvery);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    employee.setName(resultSet.getString("Name"));
                    employee.setSalary(resultSet.getInt("Salary"));
                    employee.setDate(resultSet.getDate("Date"));
                    employee.setDeptNo(resultSet.getLong("DeptNo"));
                    employee.setIdObj(resultSet.getLong("Id"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            return employee;
        }else return employee;
    }


    public boolean delete(Long Id, Integer write) throws SQLException {
        boolean result = false;
        if (write == 1) {
            Long type_id;
            PreparedStatement preparedStatement = null;
            String sqlId = "SELECT ob.OBJECT_TYPE_ID \"Type_Id\" FROM OBJECTS ob WHERE ob.OBJECT_ID = ?";
            String sqlDelTyp = "DELETE FROM OBJECT_TYPES WHERE OBJECT_TYPE_ID = ?";
            try {
                preparedStatement = connection.prepareStatement(sqlId);
                preparedStatement.setLong(1, Id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    type_id = resultSet.getLong("Type_Id");
                    preparedStatement = connection.prepareStatement(sqlDelTyp);
                    preparedStatement.setLong(1, type_id);
                    result = preparedStatement.executeQuery().next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            return result;
        }else return result;
    }

}

