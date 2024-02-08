package no.hvl.entities.order.payment;

public class Invoice implements Payment {

    public String adress;
    public String reference;


    @Override
    public boolean invoke() {
        //TODO
        return true;

    }
}
