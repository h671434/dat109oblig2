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

    @Column(name = "pickUpTime")

    private Date pickupTime;

    @Column(name = "expectedReturnTime")
    private Date expectedReturnTime;


    @Column(name = "pickupMilageInKm")
    private int pickupMileageInKm;

    @Transient
    private Payment payment;



    public Order(){}

    public Order(Costumer costumer, Car car, Date pickupTime, Date expectedReturnTime, int pickupMileageInKm, Payment payment) {
        this.costumer = costumer;
        this.car = car;
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


    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
