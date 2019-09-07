package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchema;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchemaBuilder;
import ar.edu.unq.dapp.c2a.model.time.Availability;
import ar.edu.unq.dapp.c2a.model.time.AvailabilityBuilder;
import org.springframework.jmx.access.InvalidInvocationException;

import javax.money.MonetaryAmount;
import java.io.Serializable;
import java.util.Calendar;

public class MenuBuilder implements Builder<Menu> {
    private Serializable id;
    private Business business;
    private String Nombre;
    private String Descripcion;
    private Calendar startingDate;
    private Calendar expirationDate;
    private MonetaryAmount fullPrice;

    @Override
    public Menu build() {
        if(startingDate == null || expirationDate == null) {
            //TODO: Change exception type to custom exception
            throw new InvalidInvocationException("Debe poner una fecha de inicio y una fecha de fin");
        }

        Availability availability = new AvailabilityBuilder().starting(startingDate).ending(expirationDate).build();
        PricingSchema pricingSchema = new PricingSchemaBuilder().withFullPrice(fullPrice).build();
        Menu instance = new MenuImp(business, availability, pricingSchema);
        instance.setId(id);
        return instance;
    }

    public MenuBuilder withId(Serializable id) {
        this.id = id;
        return this;
    }

    public MenuBuilder withBusiness(Business business) {
        this.business = business;
        return this;
    }

    public MenuBuilder withName(String nombre) {
        this.Nombre = nombre;
        return this;
    }

    public MenuBuilder withDescripcion(String desc) {
        this.Descripcion = desc;
        return this;
    }

    public MenuBuilder withExpirationDate(Calendar date) {
        this.expirationDate = date;
        return this;
    }

    public MenuBuilder withStartDate(Calendar date) {
        this.startingDate = date;
        return this;
    }

    public MenuBuilder withFullPrice(MonetaryAmount fullPrice) {
        this.fullPrice = fullPrice;
        return this;
    }
}
