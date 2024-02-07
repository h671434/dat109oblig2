package no.hvl.dao;

import no.hvl.entities.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CarDao extends AbstractDao<Car> {
    @Override
    public Iterable<Car> readAllEntities(Class entityClass) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            String jpql = "SELECT c from Car c";
            TypedQuery<Car> query = entityManager.createQuery(jpql, Car.class);
            return query.getResultList();
        }finally{
            entityManager.close();
        }
    }


    public Car getCar(String registrationNr){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            return entityManager.find(Car.class, registrationNr);
        }finally {
            entityManager.close();
        }
    }
}
