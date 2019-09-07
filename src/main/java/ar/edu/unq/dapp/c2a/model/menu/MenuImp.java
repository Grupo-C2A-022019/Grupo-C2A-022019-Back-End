package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.pricing.PricingSchema;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.time.Availability;

import javax.money.MonetaryAmount;
import java.util.Calendar;

public class MenuImp extends EntityImp implements Menu {
    private Business business;
    private String Nombre;
    private String descripción;
    //private List<Categoría>;
    private double valorDelivery;
    private Availability availability;
    //private tupla horarios de atencion
    private double tiempoDeEntrega;
    private final PricingSchema pricingSchema;
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

    public String getNombre(){
        return Nombre;
    }

    public String getDescripcion(){
        return descripción;
    }
}
