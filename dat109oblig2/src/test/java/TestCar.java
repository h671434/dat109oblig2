import no.hvl.dao.CarDao;
import no.hvl.entities.Car;
import no.hvl.entities.RentalGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestCar {

    private Car car1;
    private Car car2;
    private Car car3;
    private CarDao carDao;


    @BeforeEach
    void setUp(){
/*        StaticTestObjs staticTestObjs = new StaticTestObjs();
        car1 = StaticTestObjs.cars.get(0);
        car1 = StaticTestObjs.cars.get(1);
        car1 = StaticTestObjs.cars.get(2);
        StaticTestObjs.cars.get(5);
        */
        carDao = new CarDao();
    }



    @Test
    void testSave(){
        Car car = StaticTestObjs.cars.getFirst();
        carDao.writeEntity(car);
        //System.out.println(StaticTestObjs.adresses);
        //carDao.writeEntity(car1);
    }

    @Test
    void testLoad(){

    }




}
