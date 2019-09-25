package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.account.Account;
import ar.edu.unq.dapp.c2a.model.client.rating.Rate;
import ar.edu.unq.dapp.c2a.model.client.rating.Rating;
import ar.edu.unq.dapp.c2a.model.client.rating.RatingBuilder;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Client{

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Order> orders;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Menu> ratingPendingMenus;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Rating> ratings;

    public Client(Account account) {
        orders = new ArrayList<>();
        ratings = new ArrayList<>();
        ratingPendingMenus = new HashSet<>();
        this.account = account;
    }

    
    public Long getId() {
        return this.id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        Order order = menu.orderBy(this, amount, deliveryType, deliveryAppointment, customLocation);

        orders.add(order);
        ratingPendingMenus.add(menu);

        return order;
    }

    
    public Collection<Order> getOrders() {
        return orders;
    }

    
    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    
    public void pay(Invoice invoice) {
        account.pay(invoice);
    }

    
    public Collection<Menu> getRatingPendingMenus() {
        return ratingPendingMenus;
    }

    
    public void setRatingPendingMenus(Collection<Menu> ratingPendingMenus) {
        this.ratingPendingMenus = ratingPendingMenus;
    }

    
    public void rate(Rate rate, Menu aMenu) {
        ratings.add(new RatingBuilder().withRate(rate).withMenu(aMenu).build());
        ratingPendingMenus.remove(aMenu);
    }

    
    public Collection<Rating> getRatings() {
        return ratings;
    }

    
    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }
}
