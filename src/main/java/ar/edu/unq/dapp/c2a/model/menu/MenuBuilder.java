package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchema;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchemaBuilder;
import ar.edu.unq.dapp.c2a.model.time.Availability;
import ar.edu.unq.dapp.c2a.model.time.AvailabilityBuilder;

import javax.money.MonetaryAmount;

import java.util.Calendar;

public class MenuBuilder implements Builder<Menu> {
    private Long id;
    private Business business;

    private AvailabilityBuilder availabilityBuilder = new AvailabilityBuilder();
    private PricingSchemaBuilder pricingSchemaBuilder = new PricingSchemaBuilder();

    @Override
    public Menu build() {

        Availability availability = availabilityBuilder.build();

        PricingSchema pricingSchema = pricingSchemaBuilder.build();

        Menu instance = new MenuImp(business, availability, pricingSchema);

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
}
