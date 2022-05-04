package lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends DAO {

    private int id=0;

    public void create(String name,int country,boolean capital,double latitude, double longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into city (id,name,country,capital,latitude, longitude) values (?,?,?,?,?,?)")) {
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setInt(3, country);
            pstmt.setBoolean(4,capital);
            pstmt.setDouble(5,latitude);
            pstmt.setDouble(6,longitude);
            id++;
            pstmt.executeUpdate();
        }
    }

    public List<Double> findCoordinates(String name) throws SQLException {
        List<Double>info=new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude,longitude from city where name='" + name + "'")) {
            int count=5;
            while (rs.next() && count<7) {
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                info.add(rs.getDouble(count));
                count++;
            }
            return info;
           // return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from city where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from city where id='" + id + "'" )) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    public List<String> findAll() throws SQLException {
        Connection con = Database.getConnection();
        List<String> info=new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from city"  )) {
            // return rs.next() ? rs.getString(2) : null;
            int count=0;
            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));
                info.add(rs.getString(count));
                count++;
            }
            return info;
        }
    }
}
