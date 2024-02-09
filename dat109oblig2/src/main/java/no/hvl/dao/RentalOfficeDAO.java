package no.hvl.dao;

import no.hvl.entities.RentalOffice;

public class RentalOfficeDAO extends AbstractDAO<RentalOffice> {

    @Override
    public Class<RentalOffice> getEntityClass(){
        return RentalOffice.class;
    }

}
