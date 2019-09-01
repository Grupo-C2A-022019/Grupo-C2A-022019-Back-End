package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class ClientImp extends EntityImp implements Client {
    private Collection<Order> orders;

    public ClientImp() {
        orders = new ArrayList<>();
    }

    @Override
    public Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location clientLocation) {
        Order order = menu.orderBy(this, amount, deliveryType, deliveryAppointment, clientLocation);

        orders.add(order);

        return order;
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }
}
