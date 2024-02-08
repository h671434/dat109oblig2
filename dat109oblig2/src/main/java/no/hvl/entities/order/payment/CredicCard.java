package no.hvl.entities.order.payment;

public class CredicCard implements Payment {

    private int creditCardNumber;
    private int expire;
    private int CCV;

    @Override
    public boolean invoke() {
        //idk how to charge a credit card lol
        //TODO
        return true;
    }
}
