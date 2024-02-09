package no.hvl.dao;

import no.hvl.entities.RentalCompany;

public class RentalCompanyDAO extends AbstractDAO<RentalCompany> {

    @Override
    public Class<RentalCompany> getEntityClass(){
        return RentalCompany.class;
    }
}
