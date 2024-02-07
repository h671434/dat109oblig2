import entities.RentalOffice;
import entities.ReservationFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestReservationFilter {

    private RentalOffice pickupOffice;
    private RentalOffice returnOffice;

    private ReservationFilter reservationFilter1;
    private ReservationFilter reservationFilter2;


    @BeforeEach
    void setup(){
        pickupOffice = new RentalOffice( StaticTestObjs.adresses.getFirst(),
                "12312123",
                StaticTestObjs.cars.subList(0, 5)
                );
        returnOffice = new RentalOffice( StaticTestObjs.adresses.get(1),
                "12312124",
                StaticTestObjs.cars.subList(6,10));

        reservationFilter1 = new ReservationFilter(pickupOffice, returnOffice, new Date(), 5);
        reservationFilter2 = new ReservationFilter(returnOffice, pickupOffice, new Date(), 10);

    }


    @Test
    void testFindWrongCar(){

    }

    @Test
    void testFindRightCar(){

    }

    @Test
    void testOfficeNoCars(){

    }



}
