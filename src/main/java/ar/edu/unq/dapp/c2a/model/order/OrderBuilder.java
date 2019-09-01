package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;

import java.util.Calendar;

public class OrderBuilder implements Builder<Order> {
    private Client client;
    private Menu menu;
    private Integer amount;
    private DeliveryType deliveryType;
    private Calendar deliveryAppointment;
    private Business business;
    private Calendar deliveryTime;
    private Location customLocation;

    @Override
    public Order build() {
        return new OrderImp(client, menu, amount, deliveryType.getAppointment(business, client, deliveryTime, customLocation));
    }

    public OrderBuilder withClient(Client clientId) {
        this.client = clientId;
        return this;
    }

    public OrderBuilder withMenu(Menu menuId) {
        this.menu = menuId;
        return this;
    }

    public OrderBuilder withAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public OrderBuilder withBusiness(Business business) {
        this.business = business;
        return this;
    }

    public OrderBuilder withDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
        return this;
    }

    public OrderBuilder withDeliveryTime(Calendar deliveryTime) {
        this.deliveryTime = deliveryTime;
        return this;
    }

    public OrderBuilder withClientLocation(Location customLocation) {
        this.customLocation = customLocation;
        return this;
    }
}
