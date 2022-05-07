package laborator9;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.*;

@Entity
@Table(name = "cities")
@NamedQueries({
        @NamedQuery(name = "City.findAll",
                query = "select e from City e order by e.name"),
        @NamedQuery(name = "City.findByCountry",
                query = "select e from City e where e.country = ?1")
        })
public class City extends AbstractEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Long id;
    private String name;
    private String country;

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Id
    public Long getId() {
        return id;
    }

    public void create(String name,int country,boolean capital,double latitude, double longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name,country,capital,latitude, longitude) values (?,?,?,?,?)")) {
            pstmt.setInt(1,country);
            pstmt.setString(2, name);
            pstmt.setBoolean(3,capital);
            pstmt.setDouble(4,latitude);
            pstmt.setDouble(5,longitude);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        City city = new City("Iasi");
        em.persist(city);

        Continent c = (Continent)em.createQuery(
                        "select e from City e where e.name='Europe'")
                .getSingleResult();
        c.setName("Bucuresti");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

