package laborator9;

import database.ContinentsEntity;
import org.dom4j.tree.AbstractEntity;
//import jakarta.persistence.*;

import javax.lang.model.element.Name;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;


public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em; //create it somehow
    protected EntityManagerFactory emf;

    protected void createEntityManager(){
        emf = Persistence.createEntityManagerFactory("Laborator9");
        em = emf.createEntityManager();
    }

    protected void closeEntityManager(){
        em.close();
        emf.close();
    }

    public T findByName(Name name) {
        return findByName(name);
    }

    public T findById(ID id) {
        return findById(id);
    }
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
