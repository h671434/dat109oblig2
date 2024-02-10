package no.hvl.entities.order;

import no.hvl.entities.order.payment.Payment;

import java.util.Date;

public class FinishedOrder extends Order {

    private Date returnTime;

    private int returnMileageInKm;

    private Integer price;

    public FinishedOrder(String costumerPhone, String carRegistrationNr, Date pickupTime, Date expectedReturnTime, int pickupMileageInKm, Payment payment, Date returnTime, int returnMileageInKm) {
        super(costumerPhone, carRegistrationNr, pickupTime, expectedReturnTime, pickupMileageInKm, payment);
        this.returnTime = returnTime;
        this.returnMileageInKm = returnMileageInKm;
    }

    public FinishedOrder(Date returnTime, int returnMileageInKm) {
        this.returnTime = returnTime;
        this.returnMileageInKm = returnMileageInKm;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public int getReturnMileageInKm() {
        return returnMileageInKm;
    }

    public void setReturnMileageInKm(int returnMileageInKm) {
        this.returnMileageInKm = returnMileageInKm;
    }


    public Integer calculatePrice(){
        return 0;
    }


}
