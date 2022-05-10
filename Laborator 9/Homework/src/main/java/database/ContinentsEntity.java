package database;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "CONTINENTS", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
        @NamedQuery(name = "Continent.findByName",
                query = "select e from ContinentsEntity e where e.name = ?1"),
        @NamedQuery(name = "Continent.findById",
                query = "select e from ContinentsEntity e where e.id = ?1"),
})

public class ContinentsEntity extends AbstractEntity implements Serializable {
    @Id
    @Basic
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;

//    @OneToMany(mappedBy="continent")
//    private List<CountryEntity> countries;

//    public void addCountry(CountryEntity country){
//        countries.add(country);
//        if (country.getContinent() != String.valueOf(this)) {
//            country.setContinent(String.valueOf(this));
//        }
//    }

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



}
