package no.hvl.entities.order;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name ="activeOrder", schema = "dat109_oblig2")
public class ActiveOrder extends Order {

    public FinishedOrder changeStatusToFinished(Date returnTime, int returnMilageInKm){

        return new FinishedOrder(
                this.getCostumer(),
                this.getCar(),
            this.getPickupTime(),
            this.getExpectedReturnTime(),
            this.getPickupMileageInKm(),
            this.getPayment(),
            returnTime,
            returnMilageInKm
        );
    }

}
