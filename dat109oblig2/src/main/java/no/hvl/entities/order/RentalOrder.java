package no.hvl.entities.order;

import java.util.Date;
import java.util.Objects;


/**
 * DEPRECIATED
 */
public class RentalOrder {

	private String costumerPhone;
	private String carRegistrationNr;

	private Date pickupTime;
	private Date expectedReturnTime;
	private Date returnTime;
	
	private int pickupMileageInKm;
	private int returnMileageInKm;

	
	/**
	 * Constructor with all fields, except returnTime and returnMileage.
	 */
	public RentalOrder(String costumerPhone, String carRegistrationNr, Date pickupTime,
			Date expectedReturnTime, int pickupMileageInKm) {
		this.costumerPhone = costumerPhone;
		this.carRegistrationNr = carRegistrationNr;
		this.pickupTime = pickupTime;
		this.expectedReturnTime = expectedReturnTime;
		this.pickupMileageInKm = pickupMileageInKm;
	}

	public String getCostumerPhone() {
		return costumerPhone;
	}

	public void setCostumerPhone(String costumerPhone) {
		this.costumerPhone = costumerPhone;
	}

	public int getReturnMileageInKm() {
		return returnMileageInKm;
	}

	public void setReturnMileageInKm(int returnMileageInKm) {
		this.returnMileageInKm = returnMileageInKm;
	}

	public String getCarRegistrationNr() {
		return carRegistrationNr;
	}

	public void setCarRegistrationNr(String carRegistrationNr) {
		this.carRegistrationNr = carRegistrationNr;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getExpectedReturnTime() {
		return expectedReturnTime;
	}

	public void setExpectedReturnTime(Date expectedReturnTime) {
		this.expectedReturnTime = expectedReturnTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public int getPickupMileageInKm() {
		return pickupMileageInKm;
	}

	public void setPickupMileageInKm(int pickupMileageInKm) {
		this.pickupMileageInKm = pickupMileageInKm;
	}

	public int getReturnMilageInKm() {
		return returnMileageInKm;
	}

	public void setReturnMilageInKm(int returnMilageInKm) {
		this.returnMileageInKm = returnMilageInKm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carRegistrationNr, costumerPhone, expectedReturnTime, pickupMileageInKm, pickupTime,
				returnMileageInKm, returnTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		RentalOrder other = (RentalOrder) obj;
		
		return Objects.equals(carRegistrationNr, other.carRegistrationNr)
				&& Objects.equals(costumerPhone, other.costumerPhone)
				&& Objects.equals(expectedReturnTime, other.expectedReturnTime)
				&& pickupMileageInKm == other.pickupMileageInKm 
				&& Objects.equals(pickupTime, other.pickupTime)
				&& returnMileageInKm == other.returnMileageInKm
				&& Objects.equals(returnTime, other.returnTime);
	}

	public RentalOrder(String costumerPhone, String carRegistrationNr, Date pickupTime, Date expectedReturnTime,
			Date returnTime, int pickupMileageInKm, int returnMilageInKm) {
		this.costumerPhone = costumerPhone;
		this.carRegistrationNr = carRegistrationNr;
		this.pickupTime = pickupTime;
		this.expectedReturnTime = expectedReturnTime;
		this.returnTime = returnTime;
		this.pickupMileageInKm = pickupMileageInKm;
		this.returnMileageInKm = returnMilageInKm;
	}
	
}
