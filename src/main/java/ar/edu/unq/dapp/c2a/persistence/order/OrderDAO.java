package ar.edu.unq.dapp.c2a.persistence.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.GenericDAO;

import java.io.Serializable;
import java.util.Collection;

public interface OrderDAO extends GenericDAO<Order> {
    Collection<Order> getClientOrders(Serializable clientId);
}
