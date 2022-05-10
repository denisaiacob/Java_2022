package laborator9;

import database.CityEntity;
import database.ContinentsEntity;
import database.CountryEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.jpa.config.Id;

import java.util.List;
public class CityRepository extends DataRepository<CityEntity, Integer>{
    private EntityManager em; //create it somehow


    public List<CityEntity> findByCountry(CountryEntity country) {
        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
    }

    public List<CityEntity> findByName(String name) {
        return em.createNamedQuery("City.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public List<CityEntity> findById(Id id) {
        return em.createNamedQuery("City.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public void create(String name) {
        em.getTransaction().begin();
        CityEntity city = new CityEntity();
        city.setName(name);
        em.persist(city);
        em.getTransaction().commit();
    }

    public void testJPA() {

        em.getTransaction().begin();
        ContinentsEntity countryId = new ContinentsEntity("Europe");
//        em.persist(continent);

        List<CityEntity> c = (List<CityEntity>) em.createQuery(
                        "select country from CityEntity e where country=").getResultList();
             //   .getSingleResult();
        for (int i=0;i<c.size();i++){

        }
        em.getTransaction().commit();
    }
}
