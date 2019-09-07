package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import java.util.Calendar;

public interface Menu extends Entity {
    Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation);

    boolean isAvailableAt(Calendar aLaterDate);

    MonetaryAmount getPriceForOrder(Order order);

    int getAmountOfPendigs();

    Business getBusiness();
}
