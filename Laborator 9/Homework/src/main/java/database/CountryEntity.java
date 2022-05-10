package database;

import jakarta.persistence.*;
import org.dom4j.tree.AbstractEntity;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "COUNTRY", schema = "STUDENT")
@NamedQueries({
        @NamedQuery(name = "Country.findAll",
                query = "select e from CountryEntity e order by e.name"),
        @NamedQuery(name = "Country.findByName",
                query = "select e from CountryEntity e where e.name = ?1"),
        @NamedQuery(name = "Country.findById",
                query = "select e from CountryEntity e where e.id = ?1"),
})
public class CountryEntity extends AbstractEntity {
    @Id
    @Basic
    @Column(name = "ID")
    private BigInteger id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "CONTINENT")
    private String continent;

//    @OneToMany(mappedBy="country")
//    private List<CityEntity> cities;

//    public void addCity(CityEntity city){
//        cities.add(city);
//        if (city.getCountry() != String.valueOf(this)) {
//            city.setCountry(String.valueOf(this));
//        }
//    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        return result;
    }

}
