package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.client.rating.Rate;
import ar.edu.unq.dapp.c2a.model.client.rating.Rating;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.Collection;

@Entity
public interface Client {
    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar calendar, Location customLocation);

    @OneToMany
    Collection<Order> getOrders();

    void setOrders(Collection<Order> orders);

    void pay(Invoice invoice);

    @OneToMany
    Collection<Menu> getRatingPendingMenus();

    void setRatingPendingMenus(Collection<Menu> ratingPendingMenus);

    void rate(Rate rate, Menu aMenu);

    @OneToMany
    Collection<Rating> getRatings();

    void setRatings(Collection<Rating> ratings);
}
