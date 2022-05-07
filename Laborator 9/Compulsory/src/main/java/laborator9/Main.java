package laborator9;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String args[]) throws SQLException {
        try {
            City city = new City();
            city.testJPA();
            Database.getConnection().commit();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }

    }
}
