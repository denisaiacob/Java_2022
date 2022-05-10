package laborator9;

import database.CityEntity;
import database.CountryEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CityRepository extends DataRepository<CityEntity, Integer>{
    private EntityManager em; //create it somehow

    //...
    public List<CityEntity> findByCountry(CountryEntity country) {
        return em.createNamedQuery("City.findByCountry")
                .setParameter("country", country)
                .getResultList();
        //...
    }
}
