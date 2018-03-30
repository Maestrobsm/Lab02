package service;

import entry.Dept;
import entry.Entity;

import java.sql.*;


public class DeptService extends EntityService{

    public boolean create(Entity entity, Integer write) throws SQLException {
        boolean result = false;
        Dept dept = (Dept)entity;

        if ( write == 1 ) {
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQLDAO.CREATEOBTYPE.QUERY);
                preparedStatement.setLong(1, dept.getIdObjTyp());
                preparedStatement.setString(2, "DEPT");
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEOB.QUERY);
                preparedStatement.setLong(1, dept.getIdObj());
                preparedStatement.setString(2, dept.getDeptName());
                preparedStatement.setLong(3, dept.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEATR.QUERY);
                preparedStatement.setLong(1, dept.getIdLoc());
                preparedStatement.setString(2, "LOC");
                preparedStatement.setLong(3, dept.getIdObjTyp());
                preparedStatement.executeUpdate();

                preparedStatement = connection.prepareStatement(SQLDAO.CREATEPARAM.QUERY);
                preparedStatement.setString(1, dept.getLocation());
                preparedStatement.setNull(2, Types.NULL);
                preparedStatement.setDate(3, null);
                preparedStatement.setLong(4, dept.getIdLoc());
                preparedStatement.setLong(5, dept.getIdObj());
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
        if (read == 1) {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(SQLDept.GETDEPT.QUERY);
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
        } else return dept;
    }

    enum SQLDept {
        GETDEPT("SELECT ob.NAME \"Name\", par.TEXT_VALUE \"Loc\", ob.OBJECT_ID \"Id\"\n" +
                "FROM OBJECTS ob\n" +
                "INNER JOIN OBJECT_TYPES obt ON obt.OBJECT_TYPE_ID= ob.OBJECT_TYPE_ID\n" +
                "INNER JOIN ATTRIBUTES atr ON obt.OBJECT_TYPE_ID = atr.OBJECT_TYPE_ID and atr.NAME = 'LOC'\n" +
                "INNER JOIN PARAMS par ON atr.ATTR_ID = par.ATTR_ID\n" +
                "WHERE ob.OBJECT_ID = ?");

        String QUERY;

        SQLDept(String QUERY) {
            this.QUERY = QUERY;
        }
    }

}


