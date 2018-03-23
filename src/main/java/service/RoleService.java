package service;

import dao.RoleDAO;
import entry.Employee;
import entry.Role;
import util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleService extends JDBC implements RoleDAO{
    Connection connection = getConnection();

    @Override
    public Role get(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Role role = new Role();

        String qvery = "SELECT * FROM ROLES WHERE ID = ?";
        try {
            preparedStatement = connection.prepareStatement(qvery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                role.setName(resultSet.getString("ROLE"));
                role.setId(resultSet.getInt("ID"));
                role.setRead(resultSet.getInt("READ"));
                role.setWrite(resultSet.getInt("WRITE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return role;
    }
}
