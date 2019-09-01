package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;

import java.util.Calendar;

public class MenuImp extends EntityImp implements Menu {
    private Business business;

    public MenuImp(Business business) {
        super();
        this.business = business;
    }

    @Override
    public Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        return business.placeOrder(this, client, amount, deliveryType, deliveryAppointment, customLocation);
    }
}
