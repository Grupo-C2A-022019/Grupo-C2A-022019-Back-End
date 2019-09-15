package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchema;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.time.Availability;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class MenuImp implements Menu {

    @OneToOne
    private final PricingSchema pricingSchema;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Serializable id;

    @OneToOne
    private Business business;
    //    private String name;
//    private String description;
//    private List<Category> categories;
    @OneToOne
    private Availability availability;
    private int amountOfPendings = 0;


    public MenuImp(Business business, Availability availability, PricingSchema pricingSchema) {
        super();
        this.business = business;
        this.availability = availability;
        this.pricingSchema = pricingSchema;
    }

    @Override
    public Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        this.amountOfPendings += amount;
        return business.placeOrder(this, client, amount, deliveryType, deliveryAppointment, customLocation);
    }

    @Override
    public boolean isAvailableAt(Calendar aDate) {
        return availability.isAvailableAt(aDate);
    }

    @Override
    public MonetaryAmount getPriceForOrder(Order order) {
        return pricingSchema.getPrice(order);
    }

    @Override
    public int getAmountOfPendigs() {
        return this.amountOfPendings;
    }

    @Override
    public Business getBusiness() {
        return this.business;
    }

    @Override
    public void setBusiness(Business business) {
this.business = business;
    }

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }
}
