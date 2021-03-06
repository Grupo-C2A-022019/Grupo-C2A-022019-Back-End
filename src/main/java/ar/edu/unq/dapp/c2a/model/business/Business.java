package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.model.profile.BusinessProfile;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Entity
public class Business {

    private Long ownerId;
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private BusinessProfile profile;
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

    public Business() {
        orders = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        invoices = new ArrayList<>();
        offeredMenus = new ArrayList<>();
    }

    public Business(BusinessProfile profile) {
        this();
        this.profile = profile;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MonetaryAmount getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(MonetaryAmount deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<Menu> getOfferedMenus() {
        return offeredMenus;
    }

    public void setOfferedMenus(Collection<Menu> offeredMenus) {
        this.offeredMenus = offeredMenus;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }

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


    public Business withDeliveryCost(MonetaryAmount deliveryCost) {
        this.deliveryCost = deliveryCost;
        return this;
    }


    public MonetaryAmount getDeliveryPrice() {
        return this.deliveryCost;
    }


    public Collection<Invoice> collectOrders() {
        Collection<Order> collectedOrders = new ArrayDeque<>();
        Collection<Invoice> generatedInvoices = new ArrayDeque<>();
        for (Order order : pendingOrders) {
            try {
                Invoice invoice = order.pay();
                addInvoice(invoice);
                collectedOrders.add(order);
                generatedInvoices.add(invoice);
            } catch (AlreadyPaidException e) {
                // TODO: log exception
                // TODO: notify parties
            }
        }
        pendingOrders.removeAll(collectedOrders);

        return generatedInvoices;
    }

    private void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }


    public Collection<Invoice> getInvoices() {
        return invoices;
    }


    public void setInvoices(Collection<Invoice> invoices) {
        this.invoices = invoices;
    }


    public void addMenu(Menu aMenu) {
        offeredMenus.add(aMenu);
    }


    public Collection<Order> getPendingOrders() {
        return pendingOrders;
    }


    public void setPendingOrders(Collection<Order> orders) {
        this.pendingOrders = orders;
    }

    public BusinessProfile getProfile() {
        return profile;
    }

    public void setProfile(BusinessProfile profile) {
        this.profile = profile;
    }

    @Transient
    public String getName() {
        return profile.getName();
    }

    @Transient
    public String getDescription() {
        return profile.getDescription();
    }

    @Transient
    public String getImage() {
        return profile.getImage();
    }

    @Transient
    public String getUrlServ() {
        return profile.getUrlServ();
    }

    @Transient
    public String getEmail() {
        return profile.getEmail();
    }

    @Transient
    public String getSchedule() {
        return profile.getSchedule();
    }

    @Transient
    public String getTelephone() {
        return profile.getTelephone();
    }
}
