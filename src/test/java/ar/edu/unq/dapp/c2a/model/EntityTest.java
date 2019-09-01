package ar.edu.unq.dapp.c2a.model;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.geo.SimpleGeoLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;

import java.io.Serializable;
import java.util.Calendar;

public abstract class EntityTest {

    protected Serializable aClientId() {
        return "clientId";
    }

    protected Serializable aMenuId() {
        return "menuId";
    }

    protected Business aBusiness() {
        return new BusinessBuilder().build();
    }

    protected Menu aMenu() {
        return new MenuBuilder().withBusiness(aBusiness()).withId(aMenuId()).build();
    }

    protected Client aClient() {
        return new ClientBuilder().withId(aClientId()).build();
    }

    protected Integer aAmount() {
        return 1;
    }

    protected DeliveryType aDeliveryType() {
        return DeliveryType.HOME_DELIVERY;
    }

    protected Calendar aTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JANUARY, 4, 15, 25, 30);
        return calendar;
    }

    protected Location aLocation() {
        return new SimpleGeoLocation(aLat(), aLng());
    }

    protected Double aLng() {
        return -54d;
    }

    protected Double aLat() {
        return -38d;
    }
}
