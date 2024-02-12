package no.hvl.dao;

import javax.persistence.*;
import java.util.List;


/**
 * @author leo
 * @param <T> class that is entity
 */
public abstract class AbstractDAO<T> {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");

    /**
     * Writes an entity to the database.
     *
     * @param entity Entity to be written.
     */
    public void writeEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    /**
     *
     * @return entity class (reffered to as T in this context)
     */

    protected abstract Class<T> getEntityClass();

    /**
     *
     * @param id primary key of entity
     * @return whole entity of the object
     */
    public T getById(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity;
        try {
            entity = entityManager.find(getEntityClass(), id);
        } catch(EntityNotFoundException e){
            entity = null;
        } finally {
            entityManager.close();
        }
        return entity;
    }

    /**
     *
     * @return all entries in database as list of entities
     */
    public List<T> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT e FROM " + getEntityClass().getSimpleName() + " e";
            TypedQuery<T> query = entityManager.createQuery(jpql, getEntityClass());
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }



    /**
     * Deletes an entity from the database.
     *
     * @param entity Entity to be deleted.
     */
    public void deleteEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    /**
     * Deletes an entity from the database, but it is detached
     *
     * @param entity Entity to be deleted.
     */
    public void deleteDetachedEntity(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            T managedEntity = entityManager.merge(entity);
            entityManager.remove(managedEntity);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    /**
     * Saves a list of entities to the database.
     *
     * @param entities List of entities to be saved.
     */
    public void saveEntities(Iterable<T> entities) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entities.forEach(entityManager::persist);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    /**
     * Deletes all entities of the given type from the database.
     */
    public void deleteAllEntities() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM " + getEntityClass().getSimpleName()).executeUpdate();
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Merges a list of entities into the database.
     *
     * @param entities List of entities to be merged.
     */
    public void mergeEntities(Iterable<T> entities) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entities.forEach(entityManager::merge);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


    public void mergeEntity(T entity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }


}
