package no.hvl.entities.order;

import no.hvl.entities.order.payment.Payment;

import java.util.Date;

public abstract class Order {
    private String costumerPhone;
    private String carRegistrationNr;

    private Date pickupTime;
    private Date expectedReturnTime;

    private int pickupMileageInKm;

    private Payment payment;

    public Order(){}

    public Order(String costumerPhone, String carRegistrationNr, Date pickupTime, Date expectedReturnTime, int pickupMileageInKm, Payment payment) {
        this.costumerPhone = costumerPhone;
        this.carRegistrationNr = carRegistrationNr;
        this.pickupTime = pickupTime;
        this.expectedReturnTime = expectedReturnTime;
        this.pickupMileageInKm = pickupMileageInKm;
        this.payment = payment;
    }

    public String getCostumerPhone() {
        return costumerPhone;
    }

    public void setCostumerPhone(String costumerPhone) {
        this.costumerPhone = costumerPhone;
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

    public int getPickupMileageInKm() {
        return pickupMileageInKm;
    }

    public void setPickupMileageInKm(int pickupMileageInKm) {
        this.pickupMileageInKm = pickupMileageInKm;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }




}
