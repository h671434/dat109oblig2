package db;

import no.hvl.dao.CarDAO;
import no.hvl.entities.Car;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestCar {

    private Car car1;
    private CarDAO carDao;


    @BeforeEach
    void setUp(){
        car1 = StaticTestObjs.cars.getFirst();
        carDao = new CarDAO();
    }



    @Test
    void testSaveAndLoad(){
        carDao.writeEntity(car1);
        Car retrievedCar = carDao.getById(car1.getRegistrationNr());
        assertNotNull(retrievedCar);
        assertEquals(car1, retrievedCar);
        carDao.deleteEntity(car1);
    }

    @Test
    void testLoadList(){
        carDao.writeEntity(car1);
        List<Car> response = carDao.getAll();
        assertNotNull(response);
        Car carFromList = response.stream().filter(c -> c.equals(car1)).toList().getFirst();
        assertEquals(car1, carFromList);
        carDao.deleteEntity(car1);
    }

    @AfterEach
    void removeTestEntities(){

        //carDao.deleteEntity(car1);

    }




}
