package laborator9;

import jakarta.persistence.EntityManager;
import org.dom4j.tree.AbstractEntity;

import java.io.Serializable;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em; //create it somehow
    //...
    public T findById(ID id) {
        //...
        return null;
    }
    public void persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }

    private void rollback() {
    }

    private void handleException(Exception e) {
    }

    private void commit() {
    }

    private void beginTransaction() {
    }


}

