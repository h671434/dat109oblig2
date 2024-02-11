package no.hvl.entities.order;

import no.hvl.entities.Car;
import no.hvl.entities.Costumer;
import no.hvl.entities.order.payment.Payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "finishedOrder", schema = "dat109_oblig2")
public class FinishedOrder extends Order {


    @Column(name = "returnTime")
    private Date returnTime;

    @Column(name = "returnMilageInKm")
    private int returnMileageInKm;

    @Column(name = "price")
    private Integer price;

    public FinishedOrder(Costumer costumer, Car car, Date pickupTime, Date expectedReturnTime, int pickupMileageInKm, Payment payment, Date returnTime, int returnMileageInKm) {
        super(costumer, car, pickupTime, expectedReturnTime, pickupMileageInKm, payment);
        this.returnTime = returnTime;
        this.returnMileageInKm = returnMileageInKm;
    }

    public FinishedOrder(Date returnTime, int returnMileageInKm) {
        this.returnTime = returnTime;
        this.returnMileageInKm = returnMileageInKm;
    }

    public FinishedOrder() {

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
