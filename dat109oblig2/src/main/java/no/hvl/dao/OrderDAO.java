package no.hvl.dao;

import no.hvl.entities.order.Order;

public class OrderDAO extends AbstractDAO<Order> {

	@Override
	protected Class<Order> getEntityClass() {
		return Order.class;
	}

}
