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
import ar.edu.unq.dapp.c2a.model.profile.UserProfile;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.util.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Order> orders;
    @OneToOne(cascade = CascadeType.ALL)
    private UserProfile profile;
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Menu> ratingPendingMenus;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Rating> ratings;

    public Client() {
        orders = new ArrayList<>();
        ratings = new ArrayList<>();
        ratingPendingMenus = new HashSet<>();
    }

    public Client(Account account, UserProfile profile) {
        this();
        this.account = account;
        this.profile = profile;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
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


    public void setRatingPendingMenus(Set<Menu> ratingPendingMenus) {
        this.ratingPendingMenus = ratingPendingMenus;
    }


    public Rating rate(Rate rate, Menu aMenu) {
        Rating newRating = new RatingBuilder().withRate(rate).withMenu(aMenu).withClient(this).build();
        ratings.add(newRating);
        aMenu.addRating(newRating);
        ratingPendingMenus.remove(aMenu);
        return newRating;
    }


    public Collection<Rating> getRatings() {
        return ratings;
    }


    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public String getFullName() {
        return profile.getFullName();
    }

    public String getEmail() {
        return profile.getEmail();
    }

    public String getImage() {
        return profile.getImage();
    }

    public String getAddress() {
        return profile.getAddress();
    }

    public String getTelephone() {
        return profile.getTelephone();
    }

    @Transient
    public MonetaryAmount getBalance() {
        return account.getBalance();
    }

    public void addCredit(MonetaryAmount credit) {
        account.add(credit, "Carga de saldo");
    }
}
