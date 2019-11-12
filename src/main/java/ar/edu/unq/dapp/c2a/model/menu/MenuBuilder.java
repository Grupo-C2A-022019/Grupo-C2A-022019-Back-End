package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchema;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchemaBuilder;
import ar.edu.unq.dapp.c2a.model.time.Availability;
import ar.edu.unq.dapp.c2a.model.time.AvailabilityBuilder;

import javax.money.MonetaryAmount;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public class MenuBuilder implements Builder<Menu> {
    private Long id;
    private Business business;

    private String img;
    private AvailabilityBuilder availabilityBuilder = new AvailabilityBuilder();
    private PricingSchemaBuilder pricingSchemaBuilder = new PricingSchemaBuilder();
    private String name;
    private String description;
    private List<Category> categories = new ArrayList<>();


    public Menu build() {

        Availability availability = availabilityBuilder.build();

        PricingSchema pricingSchema = pricingSchemaBuilder.build();

        Menu instance = new Menu(business, name, description, categories, pricingSchema, availability,img);

        business.addMenu(instance);

        instance.setId(id);
        return instance;
    }

    public MenuBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public MenuBuilder withBusiness(Business business) {
        this.business = business;
        return this;
    }

    public MenuBuilder withExpirationDate(Calendar date) {
        availabilityBuilder.ending(date);
        return this;
    }

    public MenuBuilder withStartDate(Calendar date) {
        availabilityBuilder.starting(date);
        return this;
    }

    public MenuBuilder withFullPrice(MonetaryAmount fullPrice) {
        pricingSchemaBuilder.withFullPrice(fullPrice);
        return this;
    }

    public MenuBuilder withBulkDiscount(Integer bulkSize, MonetaryAmount discountedPrice) {
        pricingSchemaBuilder.withBulkDiscount(bulkSize, discountedPrice);
        return this;
    }

    public MenuBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MenuBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public MenuBuilder withCategories(Collection<Category> categories) {
        this.categories.addAll(categories);
        return this;
    }

    public MenuBuilder withImg(String img) {
        this.img = img;
        return this;
    }
}
