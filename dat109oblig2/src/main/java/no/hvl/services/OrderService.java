package no.hvl.services;

import java.util.Date;
import java.util.List;

import no.hvl.dao.CarDAO;
import no.hvl.dao.FinishedOrderDAO;
import no.hvl.dao.ActiveOrderDAO;
import no.hvl.entities.Car;
import no.hvl.entities.Costumer;
import no.hvl.entities.RentalOffice;
import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.FinishedOrder;
import no.hvl.entities.order.payment.Payment;

public class OrderService {
	
	private ActiveOrderDAO activeOrderDao;
	private FinishedOrderDAO finishedOrderDao;
	private CarDAO carDao;
	
	public OrderService() {
		this.activeOrderDao = new ActiveOrderDAO();
		this.finishedOrderDao = new FinishedOrderDAO();
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
		
		order.setCar(car);
		order.setCostumer(costumer);
		order.setPickupTime(pickupTime);
		order.setExpectedReturnTime(expectedReturnTime);
		order.setPayment(payment);
		order.setPickupMileageInKm(car.getMileageInKm());
		
		car.setAvailable(false);
		
		activeOrderDao.writeEntity(order);
		
		return order;
	}
	
	public FinishedOrder finishOrder(ActiveOrder active, Date returnTime, int returnMileage) {
		FinishedOrder finished = active.changeStatusToFinished(returnTime, returnMileage);
		
		activeOrderDao.deleteEntity(active);
		finishedOrderDao.writeEntity(finished);
		
		carDao.getById(active.getCar().getRegistrationNr()).setAvailable(true);
		
		return finished;
	}

}
