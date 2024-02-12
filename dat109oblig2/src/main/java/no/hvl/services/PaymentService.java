package no.hvl.services;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import no.hvl.entities.order.FinishedOrder;

public class PaymentService {

	private static final double DAILY_RATE = 2000;
	
	public double calculatePrice(FinishedOrder order) {
		Date pickupTime = order.getPickupTime();
		Date returnTime = order.getReturnTime();
		long diff = pickupTime.getTime() - returnTime.getTime();
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		return DAILY_RATE * days;
	}
	
}
