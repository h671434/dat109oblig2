package no.hvl.dat109.oblig2;

import java.util.Date;
import java.util.Objects;

/**
 * Filter used by the user to search for available cars.
 */
public class ReservationFilter {

	private RentalOffice pickupOffice;
	private RentalOffice returnOffice;
	private Date pickupTime;
	private int rentalDays;
	
	public ReservationFilter(RentalOffice pickupOffice, RentalOffice returnOffice, Date pickupTime,
			int rentalDays) {
		this.pickupOffice = pickupOffice;
		this.returnOffice = returnOffice;
		this.pickupTime = pickupTime;
		this.rentalDays = rentalDays;
	}

	public RentalOffice getPickupOffice() {
		return pickupOffice;
	}

	public void setPickupOffice(RentalOffice pickupOffice) {
		this.pickupOffice = pickupOffice;
	}

	public RentalOffice getReturnOffice() {
		return returnOffice;
	}

	public void setReturnOffice(RentalOffice returnOffice) {
		this.returnOffice = returnOffice;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getRentalDays() {
		return rentalDays;
	}

	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pickupOffice, pickupTime, rentalDays, returnOffice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ReservationFilter other = (ReservationFilter) obj;
		
		return Objects.equals(pickupOffice, other.pickupOffice) 
				&& Objects.equals(pickupTime, other.pickupTime)
				&& rentalDays == other.rentalDays 
				&& Objects.equals(returnOffice, other.returnOffice);
	}

	@Override
	public String toString() {
		return "ReservationFilter [pickupOffice=" + pickupOffice + ", returnOffice=" + returnOffice + ", pickupTime="
				+ pickupTime + ", rentalDays=" + rentalDays + "]";
	}

}
