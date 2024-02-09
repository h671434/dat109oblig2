package no.hvl.dao;

import no.hvl.entities.Car;

public class CarDAO extends AbstractDAO<Car> {

    @Override
    protected Class<Car> getEntityClass(){
        return Car.class;
    }

}
