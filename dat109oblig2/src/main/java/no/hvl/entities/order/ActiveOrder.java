package no.hvl.entities.order;

import java.util.Date;

public class ActiveOrder extends Order {

    public FinishedOrder changeStatusToFinished(Date returnTime, int returnMilageInKm){

        return new FinishedOrder(
                this.getCostumerPhone(),
                this.getCarRegistrationNr(),
            this.getPickupTime(),
            this.getExpectedReturnTime(),
            this.getPickupMileageInKm(),
            this.getPayment(),
            returnTime,
            returnMilageInKm
        );
    }

}
