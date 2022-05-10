package laborator9;

import database.CityEntity;
import database.ContinentsEntity;
import database.CountryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.jpa.config.Id;

import java.util.List;
public class CountryRepository extends DataRepository<CountryEntity, Integer>{
    private EntityManager em; //create it somehow


    public List<CountryEntity> findByName(String name) {
        return em.createNamedQuery("Country.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public List<CountryEntity> findById(Id id) {
        return em.createNamedQuery("Country.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public void create(String name) {

        em.getTransaction().begin();
        CountryEntity country = new CountryEntity();
        country.setName(name);
        em.persist(country);
        em.getTransaction().commit();
    }
}

