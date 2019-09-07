package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.geo.WithLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import java.util.Calendar;

public interface Business extends Entity, WithLocation {
    Order placeOrder(Menu menu, Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryTime, Location customLocation);

    Business withDeliveryCost(MonetaryAmount deliveryCost);

    MonetaryAmount getDeliveryPrice();
}
