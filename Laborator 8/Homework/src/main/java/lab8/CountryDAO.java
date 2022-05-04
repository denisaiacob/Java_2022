package lab8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends DAO{
    private int id=0;

    public void create(String name, int continent,String code) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (id,name,continent,code) values (?,?,?,?)")) {
            pstmt.setInt(1,id);
            pstmt.setString(2, name);
            pstmt.setInt(3, continent);
            pstmt.setString(4,code);
            id++;
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id='" + id + "'" )) {
            return rs.next() ? rs.getString(2) : null;
        }
    }

    public List<String> findAll() throws SQLException {
        List<String>info =new ArrayList<>();
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from countries"  )) {
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

