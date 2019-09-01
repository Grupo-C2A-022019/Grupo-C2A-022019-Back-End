package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;

import java.util.ArrayList;
import java.util.Collection;

public class ClientImp extends EntityImp implements Client {
    private Collection<Order> orders;

    public ClientImp() {
        orders = new ArrayList<>();
    }

    @Override
    public Order order(Menu menu) {
        Order order = new OrderBuilder().withClient(this).withMenu(menu).build();

        orders.add(order);

        return order;
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }
}
