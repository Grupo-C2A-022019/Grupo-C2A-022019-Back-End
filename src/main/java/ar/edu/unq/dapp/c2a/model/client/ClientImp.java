package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.account.Account;
import ar.edu.unq.dapp.c2a.model.client.rating.Rate;
import ar.edu.unq.dapp.c2a.model.client.rating.Rating;
import ar.edu.unq.dapp.c2a.model.client.rating.RatingBuilder;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class ClientImp extends EntityImp implements Client {
    private Collection<Order> orders;
    private Account account;
    private Collection<Menu> ratingPendingMenus;
    private Collection<Rating> ratings;

    public ClientImp(Account account) {
        orders = new ArrayList<>();
        ratings = new ArrayList<>();
        ratingPendingMenus = new HashSet<>();
        this.account = account;
    }

    @Override
    public Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        Order order = menu.orderBy(this, amount, deliveryType, deliveryAppointment, customLocation);

        orders.add(order);
        ratingPendingMenus.add(menu);

        return order;
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }

    @Override
    public void pay(Invoice invoice) {
        account.pay(invoice);
    }

    @Override
    public Collection<Menu> getRatingPendingMenus() {
        return ratingPendingMenus;
    }

    @Override
    public void rate(Rate rate, Menu aMenu) {
        ratings.add(new RatingBuilder().withRate(rate).withMenu(aMenu).build());
        ratingPendingMenus.remove(aMenu);
    }

    @Override
    public Collection<Rating> getRatings() {
        return ratings;
    }
}
