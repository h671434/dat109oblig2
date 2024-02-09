package no.hvl.dao;

import no.hvl.entities.Address;

public class AddressDAO extends AbstractDAO<Address> {


    @Override
    protected Class<Address> getEntityClass(){
        return Address.class;
    }

}
