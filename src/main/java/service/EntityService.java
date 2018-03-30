package service;

import dao.DAO;
import entry.Entity;
import util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityService extends JDBC implements DAO {
    Connection connection = getConnection();


    @Override
    public List<Entity> getAll( String name, Integer read) throws SQLException {

        List<Entity> result = new ArrayList<>();
        if (read == 1) {
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQLEntity.GETALL.QUERY);
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Entity entity = new Entity();
                    entity.setIdObj(resultSet.getLong("Id"));
                    result.add(entity);
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


    public boolean delete(Long Id, Integer write) throws SQLException {
        boolean result = false;
        if (write == 1) {
            Long type_id;
            PreparedStatement preparedStatement = null;

            try {
                preparedStatement = connection.prepareStatement(SQLEntity.ID.QUERY);
                preparedStatement.setLong(1, Id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    type_id = resultSet.getLong("Type_Id");
                    preparedStatement = connection.prepareStatement(SQLEntity.DELTYPE.QUERY);
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
        } else return result;
    }

    enum SQLEntity {
        ID("SELECT ob.OBJECT_TYPE_ID \"Type_Id\" FROM OBJECTS ob WHERE ob.OBJECT_ID = ?"),
        DELTYPE("DELETE FROM OBJECT_TYPES WHERE OBJECT_TYPE_ID = ?"),
        GETALL("SELECT ob.OBJECT_ID \"Id\" FROM OBJECTS ob \n" +
                "INNER JOIN OBJECT_TYPES obt ON ob.OBJECT_TYPE_ID= obt.OBJECT_TYPE_ID\n" +
                "where obt.NAME = ?");

        String QUERY;

        SQLEntity(String QUERY) {
            this.QUERY = QUERY;
        }
    }

    enum SQLDAO {
        CREATEOBTYPE("INSERT INTO OBJECT_TYPES (OBJECT_TYPE_ID, NAME) VALUES(?,?)"),
        CREATEOB("INSERT INTO OBJECTS (OBJECT_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)"),
        CREATEATR("INSERT INTO ATTRIBUTES (ATTR_ID, NAME, OBJECT_TYPE_ID) VALUES(?,?,?)"),
        CREATEPARAM("INSERT INTO PARAMS (TEXT_VALUE, NUMBER_VALUE, DATE_VALUE, ATTR_ID, OBJECT_ID) VALUES(?,?," +
                "to_date(?, 'yyyy/mm/dd'),?,?)");

        String QUERY;

        SQLDAO(String QUERY) {
            this.QUERY = QUERY;
        }
    }

}
