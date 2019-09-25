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
import java.util.Calendar;

@Entity
public class Menu {

    @OneToOne(cascade = CascadeType.ALL)
    private PricingSchema pricingSchema;
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Business business;
    //    private String name;
//    private String description;
//    private List<Category> categories;
    @OneToOne(cascade = CascadeType.ALL)
    private Availability availability;
    private int amountOfPendings = 0;

    public Menu() {
    }

    public Menu(Business business, Availability availability, PricingSchema pricingSchema) {
        super();
        this.business = business;
        this.availability = availability;
        this.pricingSchema = pricingSchema;
    }


    public Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        this.amountOfPendings += amount;
        return business.placeOrder(this, client, amount, deliveryType, deliveryAppointment, customLocation);
    }


    public boolean isAvailableAt(Calendar aDate) {
        return availability.isAvailableAt(aDate);
    }


    public MonetaryAmount getPriceForOrder(Order order) {
        return pricingSchema.getPrice(order);
    }


    public int getAmountOfPendigs() {
        return this.amountOfPendings;
    }


    public Business getBusiness() {
        return this.business;
    }


    public void setBusiness(Business business) {
        this.business = business;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
