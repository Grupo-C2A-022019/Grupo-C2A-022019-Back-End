package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.client.rating.Rate;
import ar.edu.unq.dapp.c2a.model.client.rating.Rating;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import java.util.Calendar;
import java.util.Collection;

public interface Client extends Entity {
    Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar calendar, Location customLocation);

    Collection<Order> getOrders();

    void pay(Invoice invoice);

    Collection<Menu> getRatingPendingMenus();

    void rate(Rate rate, Menu aMenu);

    Collection<Rating> getRatings();
}
