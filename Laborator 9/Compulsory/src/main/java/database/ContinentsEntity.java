package database;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "CONTINENTS", schema = "STUDENT", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
})

public class ContinentsEntity implements Serializable {
    @Id
    @Basic
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;

    public ContinentsEntity(String name) {
        this.name=name;
    }

    public ContinentsEntity() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ContinentsEntity continent = new ContinentsEntity("Europe");
        em.persist(continent);

        ContinentsEntity c = (ContinentsEntity) em.createQuery(
                        "select e from ContinentsEntity e where e.name='Europe'")
                .getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
