import java.time.LocalDate;
import java.util.List;

import no.hvl.services.OrderService;

public class OrderServiceTest {
	
	@Mock
	private ActiveOrderDAO mockActiveOrderDao;
	
	@Mock
	private FinishedOrderDAO mockFinishedOrderDao;
	
	@Mock
	private CarDAO mockCarDao;
		
	@InjectMocks
	private OrderService service;
	
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
		
		Assertions.assertTrue(available.stream().allMatch(c -> c.isAvailable()));
		Assertions.assertTrue(available.size() == 5);
	}
	
	@Test
	public void makeOrderTest() {
		List<ActiveOrder> mockActiveOrderList = new ArrayList<>();
		
		Mockito.when(mockActiveOrder.writeEntity(Mockito.any()))
				.then(i -> mockActiveOrderList.add(i));
		
		Car car = new Car("1", null, null, null, null, true, null, 0);
		ActiveOrder order = service.makeOrder(car, null, null, null, null);
		
		Assertions.assertTrue(order != null);
		Assertions.assertTrue(mockActiveOrderList.size() == 1);
		Assertions.assertFalse(car.isAvailable());
	}
	
	@Test
	public void finishOrderTest() {
		List<ActiveOrder> mockActiveOrderList = new ArrayList<>();
		List<ActiveOrder> mockFinishedOrderList = new ArrayList<>();
		
		Mockito.when(mockActiveOrder.deleteEntity(Mockito.any()))
				.then(i -> mockActiveOrderList.remove(i));
		Mockito.when(mockFinishedOrder.writeEntity(Mockito.any()))
				.then(i -> mockActiveOrderList.add(i));

		
		Car car = new Car("1", null, null, null, null, false, null, 0);
		ActiveOrder activeorder = new ActiveOrder(car, null, null, null, null);
		
		mockActiveOrderList.add(activeorder);
		
		FinishedOrder finishedorder = service.finishOrder(activeorder, null, 0);
		
		Assertions.assertTrue(finishedorder != null);
		Assertions.assertTrue(mockActiveOrderList.size() == 0);
		Assertions.assertTrue(mockFinishedOrderList.size() == 1);
		Assertions.assertTrue(car.isAvailable());
	}
	
}
