import no.hvl.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestCar {

    private Car car1;
    private Car car2;
    private Car car3;


    @BeforeEach
    void setUp(){
        car1 = StaticTestObjs.cars.get(0);
        car1 = StaticTestObjs.cars.get(1);
        car1 = StaticTestObjs.cars.get(2);
    }



    @Test
    void testSave(){

    }

    @Test
    void testLoad(){

    }




}
