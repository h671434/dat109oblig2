package no.hvl.entities.order;

import java.util.Date;

public class ActiveOrder extends Order {

    public OldOrder changeStatusToFinished(Date returnTime, int returnMilageInKm){

        return new OldOrder(
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
