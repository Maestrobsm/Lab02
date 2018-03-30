package service;

import entry.Employee;
import entry.Entity;

import java.sql.*;


public class EmployeeService extends EntityService {

    public boolean create(Entity entity, Integer write) throws SQLException {
        boolean result = false;
        Employee employee = (Employee)entity;
        if ( write == 1) {
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQLDAO.CREATEOBTYPE.QUERY);
                preparedStatement.setLong(1, employee.getIdObjTyp());
                preparedStatement.setString(2, "EMPLOYEE");
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEOB.QUERY);
                preparedStatement.setLong(1, employee.getIdObj());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEATR.QUERY);
                preparedStatement.setLong(1, employee.getIdSal());
                preparedStatement.setString(2, "SALARY");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();


                preparedStatement = connection.prepareStatement(SQLDAO.CREATEPARAM.QUERY);
                preparedStatement.setString(1, null);
                preparedStatement.setInt(2, employee.getSalary());
                preparedStatement.setDate(3, null);
                preparedStatement.setLong(4, employee.getIdSal());
                preparedStatement.setLong(5, employee.getIdObj());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEATR.QUERY);
                preparedStatement.setLong(1, employee.getIdDat());
                preparedStatement.setString(2, "DATE");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEPARAM.QUERY);
                preparedStatement.setString(1, null);
                preparedStatement.setNull(2, Types.NULL);
                preparedStatement.setString(3, employee.getDate());
                preparedStatement.setLong(4, employee.getIdDat());
                preparedStatement.setLong(5, employee.getIdObj());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEATR.QUERY);
                preparedStatement.setLong(1, employee.getIdDept());
                preparedStatement.setString(2, "DEPT_NO");
                preparedStatement.setLong(3, employee.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEPARAM.QUERY);
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

            try {
                preparedStatement = connection.prepareStatement(SQLEmployee.GETEMP.QUERY);
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    employee.setName(resultSet.getString("Name"));
                    employee.setSalary(resultSet.getInt("Salary"));
                    employee.setDate(resultSet.getDate("Date").toString());
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

    enum SQLEmployee {
        GETEMP("SELECT ob.NAME \"Name\", par.NUMBER_VALUE \"Salary\", par2.DATE_VALUE \"Date\"," +
                "par1.NUMBER_VALUE \"DeptNo\", ob.OBJECT_ID \"Id\"\n" +
                "FROM OBJECTS ob \n" +
                "INNER JOIN OBJECT_TYPES obt ON ob.OBJECT_TYPE_ID= obt.OBJECT_TYPE_ID\n" +
                "INNER JOIN ATTRIBUTES atr ON obt.OBJECT_TYPE_ID = atr.OBJECT_TYPE_ID and atr.NAME = 'SALARY'\n" +
                "INNER JOIN PARAMS par ON atr.ATTR_ID = par.ATTR_ID\n" +
                "INNER JOIN ATTRIBUTES atr1 ON obt.OBJECT_TYPE_ID = atr1.OBJECT_TYPE_ID and atr1.NAME = 'DEPT_NO'\n" +
                "INNER JOIN PARAMS par1 ON atr1.ATTR_ID = par1.ATTR_ID\n" +
                "INNER JOIN ATTRIBUTES atr2 ON obt.OBJECT_TYPE_ID = atr2.OBJECT_TYPE_ID and atr2.NAME = 'DATE'\n" +
                "INNER JOIN PARAMS par2 ON atr2.ATTR_ID = par2.ATTR_ID\n" +
                "where ob.OBJECT_ID = ?");

        String QUERY;

        SQLEmployee(String QUERY) {
            this.QUERY = QUERY;
        }
    }

}

