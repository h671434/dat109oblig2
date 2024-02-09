package no.hvl.dao;

import no.hvl.entities.Costumer;

public class CostumerDAO extends AbstractDAO<Costumer> {
    @Override
    protected Class<Costumer> getEntityClass() {
        return Costumer.class;
    }
}
