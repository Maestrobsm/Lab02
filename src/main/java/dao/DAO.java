package dao;


import entry.Entity;
import java.sql.SQLException;
import java.util.List;

public interface DAO {

    boolean create(Entity entity, Integer write) throws SQLException;

    Entity get(Long id, Integer read) throws SQLException;

    boolean delete(Long Id, Integer write) throws SQLException;

    /**
     * Lazy download
     */
    List<Entity> getAll(String name, Integer read) throws SQLException;

}
