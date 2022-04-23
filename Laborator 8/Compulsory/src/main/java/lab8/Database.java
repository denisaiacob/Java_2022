package lab8;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection=null;

    private Database() {
    }
    public static Connection getConnection(){
        createConnection();
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }
}
