package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

@javax.persistence.Entity
public interface Business {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    Order placeOrder(Menu menu, Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryTime, Location customLocation);

    Business withDeliveryCost(MonetaryAmount deliveryCost);

    @Transient
    MonetaryAmount getDeliveryPrice();

    void collectOrders();

    @OneToMany
    Collection<Invoice> getInvoices();

    void setInvoices(Collection<Invoice> invoices);

    void addMenu(Menu instance);

    @OneToMany
    Collection<Order> getPendingOrders();

    void setPendingOrders(Collection<Order> orders);
}
