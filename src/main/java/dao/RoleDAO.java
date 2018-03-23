package dao;

import entry.Role;

import java.sql.SQLException;

public interface RoleDAO {

   Role get(Integer id) throws SQLException;

}
