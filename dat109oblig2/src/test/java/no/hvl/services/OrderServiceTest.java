package no.hvl.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import no.hvl.dao.ActiveOrderDAO;
import no.hvl.dao.CarDAO;
import no.hvl.dao.FinishedOrderDAO;
import no.hvl.entities.Car;
import no.hvl.entities.RentalOffice;
import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.FinishedOrder;
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
		MockitoAnnotations.openMocks(this);
		
		OrderService service = new OrderService();
		RentalOffice office = new RentalOffice(null, null, List.of(
				new Car("1", null, null, null, null, true, null, 0),
				new Car("2", null, null, null, null, true, null, 0),
				new Car("3", null, null, null, null, true, null, 0),
				new Car("4", null, null, null, null, true, null, 0),
				new Car("5", null, null, null, null, true, null, 0),
				new Car("6", null, null, null, null, false, null, 0),
				new Car("7", null, null, null, null, false, null, 0)));
		Date now = new Date();
		int days = 5;
		
		List<Car> available = service.getAvailableCars(office, office, now, days);
		
		Assertions.assertTrue(available.stream().allMatch(c -> c.isAvailable()));
		Assertions.assertTrue(available.size() == 5);
	}
	
	@Test
	public void makeOrderTest() {
		MockitoAnnotations.openMocks(this);
		
		List<ActiveOrder> mockActiveOrderList = new ArrayList<>();
		
		Mockito.doAnswer(i -> mockActiveOrderList.add((ActiveOrder) i))
				.when(mockActiveOrderDao).writeEntity(Mockito.any(ActiveOrder.class));

		Car car = new Car("1", null, null, null, null, true, null, 0);
		ActiveOrder order = service.makeOrder(car, null, null, null, null);
		
		Assertions.assertTrue(order != null);
		Assertions.assertFalse(car.isAvailable());
	}
	
	@Test
	public void finishOrderTest() {
		MockitoAnnotations.openMocks(this);
		
		List<ActiveOrder> mockActiveOrderList = new ArrayList<>();
		List<FinishedOrder> mockFinishedOrderList = new ArrayList<>();
		
		Car car = new Car("1", null, null, null, null, false, null, 0);
		ActiveOrder activeorder = new ActiveOrder();
		
		activeorder.setCar(car);
		mockActiveOrderList.add(activeorder);
		
		Mockito.doAnswer(i -> mockActiveOrderList.remove((ActiveOrder) i))
				.when(mockActiveOrderDao).deleteEntity(Mockito.any(ActiveOrder.class));
		Mockito.doAnswer(i -> mockFinishedOrderList.add((FinishedOrder) i))
				.when(mockFinishedOrderDao).writeEntity(Mockito.any(FinishedOrder.class));
		Mockito.when(mockCarDao.getById(Mockito.anyString()))
			.then(i -> car);
		
		FinishedOrder finishedorder = service.finishOrder(activeorder, null, 0);

        Assertions.assertNotNull(finishedorder);
		Assertions.assertTrue(car.isAvailable());
	}
	
}
