package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.geo.WithLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;

import java.util.Calendar;
import java.util.Collection;

public interface Client extends Entity, WithLocation {
    Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar calendar, Location customLocation);

    Collection<Order> getOrders();
}
