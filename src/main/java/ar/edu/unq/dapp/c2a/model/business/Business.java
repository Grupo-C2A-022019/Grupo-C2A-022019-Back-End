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
public class Business {

    private Long ownerId;
    private String name;
    private String description;
    private String img;
    private String urlServ;
    private String email;
    private String schedule;
    private Integer tel;
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
    public Business() {
        orders = new ArrayList<>();
        pendingOrders = new ArrayList<>();
        invoices = new ArrayList<>();
        offeredMenus = new ArrayList<>();
    }
    public Business(String name, String desctiption) {
        this();
        this.name = name;
        this.description = desctiption;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImg() {
        return this.img;
    }

    public String getUrlServ() {
    return this.urlServ;
    }

    public String getEmail() {
    return this.email;
    }

    public String getSchedule() {
    return this.schedule;
    }

    public Integer getTel() {
    return this.tel;
    }

    private void setImg(String img){
        this.img = img;
    }
    private void setUrlServ(String urlServ){
        this.urlServ = urlServ;
    }
    private void setEmail(String email){
        this.email = email;
    }
    private void setSchedule(String schedule){
        this.schedule = schedule;
    }
    private void setTel(Integer tel){
        this.tel = tel;
    }

}
