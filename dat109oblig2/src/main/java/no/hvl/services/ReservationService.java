package no.hvl.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import no.hvl.dao.OrderDAO;
import no.hvl.dao.RentalOfficeDAO;
import no.hvl.entities.Car;
import no.hvl.entities.Costumer;
import no.hvl.entities.RentalOffice;
import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.Order;

public class ReservationService {
	
	private OrderDAO dao;
	
	public ReservationService() {
		this.dao = new OrderDAO();
	}
	
	public List<Car> getAvailableCars(RentalOffice pickupOffice, 
			RentalOffice returnOffice, Date pickupTime, int rentalDays) {
		return pickupOffice.getAvailableCars();
		
	}
	

}
