package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;

import java.util.ArrayList;
import java.util.Collection;

public class BusinessImp extends EntityImp implements Business {
    private Collection<Order> orders;

    public BusinessImp() {
        orders = new ArrayList<>();
    }

    @Override
    public Order placeOrder(Menu menu, Client client) {
        Order order = new OrderBuilder().withClient(client).withMenu(menu).build();

        orders.add(order);

        return order;
    }
}
