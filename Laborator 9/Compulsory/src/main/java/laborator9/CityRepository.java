package laborator9;

import jakarta.persistence.EntityManager;

import java.util.List;

public class CityRepository extends DataRepository<City, Integer> {

    private EntityManager em; //create it somehow
 //...
 public List<City> findByCountry(Country country) {
     return em.createNamedQuery("City.findByCountry")
             .setParameter("country", country)
             .getResultList();
 //...
    }
}
