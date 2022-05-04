package lab8;

import java.sql.SQLException;
import java.util.List;

public abstract class DAO {

    public abstract Integer findByName(String name) throws SQLException;
    public abstract String findById(int id) throws SQLException;
    public abstract List<String> findAll() throws SQLException;
}
