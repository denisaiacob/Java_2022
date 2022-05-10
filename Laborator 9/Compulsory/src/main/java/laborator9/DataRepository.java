package laborator9;

import org.dom4j.tree.AbstractEntity;
import jakarta.persistence.*;

import java.io.Serializable;


public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em; //create it somehow

    public void create() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
    }
 //...
    //public T findById(ID id) {
 //...
      //  return
    //}
    public void persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
          //  return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }

    private void commit() {
    }

    private void beginTransaction() {
    }

    private void handleException(Exception e) {
    }

    private void rollback() {

    }
}
