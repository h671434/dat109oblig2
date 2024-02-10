package no.hvl.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import no.hvl.dao.CarDAO;
import no.hvl.dao.OrderDAO;
import no.hvl.dao.RentalOfficeDAO;
import no.hvl.entities.Car;
import no.hvl.entities.Costumer;
import no.hvl.entities.RentalOffice;
import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.FinishedOrder;
import no.hvl.entities.order.Order;
import no.hvl.entities.order.payment.Payment;

public class OrderService {
	
	private OrderDAO orderDao;
	private CarDAO carDao;
	
	public OrderService() {
		this.orderDao = new OrderDAO();
		this.carDao = new CarDAO();
	}
	
	public List<Car> getAvailableCars(RentalOffice pickupOffice, 
			RentalOffice returnOffice, Date pickupTime, int rentalDays) {
		return pickupOffice.getAvailableCars();
		
	}
	
	public ActiveOrder makeOrder(Car car, Costumer costumer, Date pickupTime, 
			Date expectedReturnTime, Payment payment) {
		if(!car.isAvailable()) {
			throw new IllegalArgumentException("Car is not available");
		}
		
		ActiveOrder order = new ActiveOrder();
		
		order.setCarRegistrationNr(car.getRegistrationNr());
		order.setCostumerPhone(costumer.getPhone());
		order.setPickupTime(pickupTime);
		order.setExpectedReturnTime(expectedReturnTime);
		order.setPayment(payment);
		order.setPickupMileageInKm(car.getMileageInKm());
		
		car.setAvailable(false);
		
		orderDao.writeEntity(order);
		
		return order;
	}
	
	public FinishedOrder finishOrder(ActiveOrder active, Date returnTime, int returnMileage) {
		FinishedOrder finished = active.changeStatusToFinished(returnTime, returnMileage);
		
		orderDao.deleteEntity(active);
		orderDao.writeEntity(finished);
		
		carDao.getById(active.getCarRegistrationNr()).setAvailable(true);
		
		return finished;
	}

}
