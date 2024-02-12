package no.hvl.dao;

import no.hvl.entities.order.ActiveOrder;
import no.hvl.entities.order.Order;

public class ActiveOrderDAO extends AbstractDAO<ActiveOrder> {

	@Override
	protected Class<ActiveOrder> getEntityClass() {
		return ActiveOrder.class;
	}

}
