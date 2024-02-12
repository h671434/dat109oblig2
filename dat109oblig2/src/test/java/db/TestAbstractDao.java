package db;

import no.hvl.dao.CarDAO;
import no.hvl.dao.ActiveOrderDAO;
import no.hvl.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestAbstractDao {

    @Test
    void testCarDao(){
        CarDAO carDao = new CarDAO();
        Car car1 = StaticTestObjs.cars.get(0);
        carDao.writeEntity(car1);
        Car retrievedCar = carDao.getById(car1.getRegistrationNr());
        assertNotNull(retrievedCar);
        assertEquals(car1, retrievedCar);
        carDao.deleteEntity(car1);
    }

    @Test
    void testAddressDao(){
        CarDAO carDao = new CarDAO();
        Car car1 = StaticTestObjs.cars.get(0);
        carDao.writeEntity(car1);
        Car retrievedCar = carDao.getById(car1.getRegistrationNr());
        assertNotNull(retrievedCar);
        assertEquals(car1, retrievedCar);
        carDao.deleteEntity(car1);

    }

    @Test
    void testOrderDao(){
    }

    @Test
    void testRentalGroupDao(){

    }

    @Test
    void testRentalCompanyDao(){

    }



}
