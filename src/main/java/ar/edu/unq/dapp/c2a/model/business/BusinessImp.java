package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class BusinessImp extends EntityImp implements Business {
    private Collection<Order> orders;
    private Location location;
    private MonetaryAmount deliveryCost = Monetary.getDefaultAmountFactory().setNumber(0).setCurrency("ARS").create();

    public BusinessImp() {
        orders = new ArrayList<>();
    }

    @Override
    public Order placeOrder(Menu menu, Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryTime, Location customLocation) {
        Order order = new OrderBuilder()
                .withClient(client)
                .withMenu(menu)
                .withAmount(amount)
                .withBusiness(this)
                .withDeliveryType(deliveryType)
                .withDeliveryTime(deliveryTime)
                .withClientLocation(customLocation)
                .build();

        orders.add(order);

        return order;
    }

    @Override
    public Business withDeliveryCost(MonetaryAmount deliveryCost) {
        this.deliveryCost = deliveryCost;
        return this;
    }

    @Override
    public MonetaryAmount getDeliveryPrice() {
        return this.deliveryCost;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
