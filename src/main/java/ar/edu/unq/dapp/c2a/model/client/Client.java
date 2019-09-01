package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;

import java.util.Collection;

public interface Client extends Entity {
    Order order(Menu menu);

    Collection<Order> getOrders();
}
