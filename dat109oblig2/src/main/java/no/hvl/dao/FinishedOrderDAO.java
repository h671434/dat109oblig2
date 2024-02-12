package no.hvl.dao;

import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.FinishedOrder;

public class FinishedOrderDAO extends AbstractDAO<FinishedOrder> {

	@Override
	protected Class<FinishedOrder> getEntityClass() {
		return FinishedOrder.class;
	}

}
