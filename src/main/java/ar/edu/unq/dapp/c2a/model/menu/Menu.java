package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.category.Category;
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
import java.util.Date;
import java.util.List;

@Entity
public class Menu {

    @OneToOne(cascade = CascadeType.ALL)
    private PricingSchema pricingSchema;
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Business business;
    @OneToOne(cascade = CascadeType.ALL)
    private Availability availability;
    private int amountOfPendings = 0;
    private String name;
    private String description;
    @ManyToMany
    private List<Category> categories;

    private Date removedAt;

    public Menu() {
    }

    public Menu(
            Business business,
            String name,
            String description,
            List<Category> categories,
            PricingSchema pricingSchema,
            Availability availability
    ) {
        this.pricingSchema = pricingSchema;
        this.business = business;
        this.availability = availability;
        this.name = name;
        this.description = description;
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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

    @Transient
    public MonetaryAmount getListPrice() {
        return pricingSchema.getListPrice();
    }

    @Transient
    public MonetaryAmount getDiscountPrice() {
        return pricingSchema.getDiscountPrice(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public Calendar getStartingDate() {
        return this.availability.getStartingDate();
    }

    @Transient
    public Calendar getExpirationDate() {
        return this.availability.getExpirationDate();
    }

    @Transient
    public Integer getBulkSize() {
        return this.pricingSchema.getBulkSize();
    }
}
