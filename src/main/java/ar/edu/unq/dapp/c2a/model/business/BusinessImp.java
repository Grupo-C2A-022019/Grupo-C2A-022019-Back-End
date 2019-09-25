package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Entity
public class BusinessImp implements Business {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount deliveryCost = Monetary.getDefaultAmountFactory().setNumber(0).setCurrency("ARS").create();
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Order> orders;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Order> pendingOrders;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Invoice> invoices;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Menu> offeredMenus;
    public BusinessImp() {
        orders = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        invoices = new ArrayList<>();
        offeredMenus = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Order placeOrder(Menu menu, Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryTime, Location customLocation) {
        Order order = new OrderBuilder()
                .withClient(client)
                .withMenu(menu)
                .withAmount(amount)
                .withBusiness(this)
                .withDeliveryType(deliveryType)
                .withDeliveryTime(deliveryTime)
                .withClientLocation(customLocation)
                .build();

        addPendingOrder(order);

        return order;
    }

    private void addPendingOrder(Order order) {
        orders.add(order);
        pendingOrders.add(order);
    }

    @Override
    public Business withDeliveryCost(MonetaryAmount deliveryCost) {
        this.deliveryCost = deliveryCost;
        return this;
    }

    @Override
    public MonetaryAmount getDeliveryPrice() {
        return this.deliveryCost;
    }

    @Override
    public void collectOrders() {
        Collection<Order> collectedOrders = new ArrayDeque<>();
        for (Order order : pendingOrders) {
            try {
                addInvoice(order.pay());
                collectedOrders.add(order);
            } catch (AlreadyPaidException e) {
                // TODO: log exception
                // TODO: notify parties
            }
        }
        pendingOrders.removeAll(collectedOrders);
    }

    private void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public Collection<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public void setInvoices(Collection<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public void addMenu(Menu aMenu) {
        offeredMenus.add(aMenu);
    }

    @Override
    public Collection<Order> getPendingOrders() {
        return pendingOrders;
    }

    @Override
    public void setPendingOrders(Collection<Order> orders) {
        this.pendingOrders = orders;
    }
}
