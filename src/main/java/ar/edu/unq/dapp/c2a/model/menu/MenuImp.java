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
public class MenuImp implements Menu {

    @OneToOne(cascade = CascadeType.ALL)
    private final PricingSchema pricingSchema;
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
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
