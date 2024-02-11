package no.hvl.entities.order;

import no.hvl.entities.Car;
import no.hvl.entities.Costumer;
import no.hvl.entities.RentalOffice;
import no.hvl.entities.order.payment.Payment;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
public abstract class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "costumerPhone", referencedColumnName = "phone")
    private Costumer costumer;


    @ManyToOne
    @JoinColumn(name = "registrationNr", referencedColumnName = "registrationNr")
    private Car car;

    @Column(name = "")

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isExpectedReturnedBy(Date time) {
    	return expectedReturnTime.before(time);
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
