package laborator9;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASSWORD = "STUDENT";
    private static Connection connection=null;

    private Database() {
    }
    public static Connection getConnection() throws SQLException {
        createConnection();
        return connection;
    }
    public static void createConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection() throws SQLException {
        try{
            if(connection!=null){
                connection.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() throws SQLException {
        connection.rollback();
    }
}
