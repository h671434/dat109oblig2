import no.hvl.dat109.oblig2.RentalOffice;
import no.hvl.dat109.oblig2.ReservationFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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

        reservationFilter1 = new ReservationFilter()

    }


    @Test


}
