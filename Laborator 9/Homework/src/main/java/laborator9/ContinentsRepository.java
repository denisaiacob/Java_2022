package laborator9;

import database.CityEntity;
import database.ContinentsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.jpa.config.Id;

import java.util.List;
public class ContinentsRepository extends DataRepository<ContinentsEntity, Integer>{
    private EntityManager em; //create it somehow


    public List<ContinentsEntity> findByName(String name) {
        return em.createNamedQuery("Continent.findByName")
                .setParameter("name", name)
                .getResultList();
    }

    public List<ContinentsEntity> findById(Id id) {
        return em.createNamedQuery("Continent.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public void create(String name) {

        em.getTransaction().begin();
        ContinentsEntity continents = new ContinentsEntity();
        continents.setName(name);
        em.persist(continents);
        em.getTransaction().commit();
    }

    public void testJPA() {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("Laborator9");
//        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ContinentsEntity continent = new ContinentsEntity("Europe");
        em.persist(continent);

        ContinentsEntity c = (ContinentsEntity) em.createQuery(
                        "select e from ContinentsEntity e where e.name='Europe'")
                .getSingleResult();
        c.setName("Africa");
        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
}

