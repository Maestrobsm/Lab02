package service;

import dao.DeptDAO;
import entry.Dept;
import util.JDBC;

import java.sql.*;

public class DeptService extends JDBC implements DeptDAO {

    Connection connection = getConnection();

    public boolean create(Dept dept, Integer write) throws SQLException {
        boolean result = false;

        if ( write == 1 ) {
            PreparedStatement preparedStatement = null;

            String sqlObTyp = "INSERT INTO OBJECT_TYPES (OBJECT_TYPE_ID, NAME) VALUES(?,?)";
            String sqlObj = "INSERT INTO OBJECTS (OBJECT_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)";
            String sqlAttr = "INSERT INTO ATTRIBUTES (ATTR_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)";
            String sqlParam = "INSERT INTO PARAMS (TEXT_VALUE, NUMBER_VALUE, DATE_VALUE, ATTR_ID, OBJECT_ID) VALUES(?,?," +
                    "to_date(?, 'dd/mm/yyyy'),?,?)";

            try {
                preparedStatement = connection.prepareStatement(sqlObTyp);
                preparedStatement.setLong(1, dept.getIdObjTyp());
                preparedStatement.setString(2, "DEPT");
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlObj);
                preparedStatement.setLong(1, dept.getIdObj());
                preparedStatement.setString(2, dept.getDeptName());
                preparedStatement.setLong(3, dept.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlAttr);
                preparedStatement.setLong(1, dept.getIdLoc());
                preparedStatement.setString(2, "LOC");
                preparedStatement.setLong(3, dept.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(sqlParam);
                preparedStatement.setString(1, dept.getLocation());
                preparedStatement.setNull(2, Types.NULL);
                preparedStatement.setDate(3, null);
                preparedStatement.setLong(4, dept.getIdLoc());
                preparedStatement.setLong(5, dept.getIdObj());
                preparedStatement.executeUpdate();
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


    public Dept get(Long deptNo, Integer read) throws SQLException {
        Dept dept = new Dept();
        if (read ==1) {
        PreparedStatement preparedStatement = null;

        String qvery = "SELECT ob.NAME \"Name\", par.TEXT_VALUE \"Loc\", ob.OBJECT_ID \"Id\"\n" +
                "FROM OBJECTS ob\n" +
                "INNER JOIN OBJECT_TYPES obt ON obt.OBJECT_TYPE_ID= ob.OBJECT_TYPE_ID\n" +
                "INNER JOIN ATTRIBUTES atr ON obt.OBJECT_TYPE_ID = atr.OBJECT_TYPE_ID and atr.NAME = 'LOC'\n" +
                "INNER JOIN PARAMS par ON atr.ATTR_ID = par.ATTR_ID\n" +
                "WHERE ob.OBJECT_ID = ?";

        try {
            preparedStatement = connection.prepareStatement(qvery);
            preparedStatement.setLong(1,deptNo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dept.setDeptName(resultSet.getString("Name"));
                dept.setLocation(resultSet.getString("Loc"));
                dept.setIdObj(resultSet.getLong("Id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }return dept;
        }else
        return dept;
    }

    public boolean delete(Long Id, Integer write) throws SQLException {
        boolean result = false;
        if (write ==1) {
        Long type_id;
        PreparedStatement preparedStatement = null;
        String sqlId = "SELECT ob.OBJECT_TYPE_ID \"Type_Id\" FROM OBJECTS ob WHERE ob.OBJECT_ID = ?";
        String sql = "DELETE FROM OBJECT_TYPES WHERE OBJECT_TYPE_ID = ?";
        try { preparedStatement = connection.prepareStatement(sqlId);
            preparedStatement.setLong(1,Id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                type_id = resultSet.getLong("Type_Id");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, type_id);
                result = preparedStatement.executeQuery().next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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


