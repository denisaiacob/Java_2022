package lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO extends DAO{

    public void create(int id,String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into CONTINENTS (id,name) values (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continent where id='" + id + "'" )) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    public List<String> findAll() throws SQLException {
        List<String>info=new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from continents"  )) {
            //return rs.next() ? rs.getString(2) : null;

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
