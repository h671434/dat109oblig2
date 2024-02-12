import java.time.LocalDate;
import java.util.List;

import no.hvl.services.OrderService;

public class OrderServiceTest {
	
	@InjectMocks
	private OrderService service;
	
	@Mock
	private ActiveOrderDAO mockActiveOrderDao;
	
	@Mock
	private FinishedOrderDAO mockFinishedOrderDao;
	
	@Mock
	private CarDAO mockCarDao:
	
	@Test
	public void getAvailableCarsTest() {
		OrderService service = new OrderService();
		RentalOffice office = new RentalOffice(null, null, List.of(
				new Car("1", null, null, null, null, true, null, 0),
				new Car("2", null, null, null, null, true, null, 0),
				new Car("3", null, null, null, null, true, null, 0),
				new Car("4", null, null, null, null, true, null, 0),
				new Car("5", null, null, null, null, true, null, 0),
				new Car("6", null, null, null, null, false, null, 0),
				new Car("7", null, null, null, null, false, null, 0)));
		Date now = LocalDate.now();
		int days = 5;
		
		List<Car> available = service.getAvailableCars(office, office, now, days);
		
		assertTrue(available)
	}
	
	@Test
	public void makeOrderTest() {
		
	}
	
	@Test
	public void finishOrderTest() {
		
	}
	
}
