package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.account.Account;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

public class ClientImp extends EntityImp implements Client {
    private Collection<Order> orders;
    private Location location;
    private Account account;

    public ClientImp(Account account) {
        orders = new ArrayList<>();
        this.account = account;
    }

    @Override
    public Order order(Menu menu, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation) {
        Order order = menu.orderBy(this, amount, deliveryType, deliveryAppointment, customLocation);

        orders.add(order);

        return order;
    }

    @Override
    public Collection<Order> getOrders() {
        return orders;
    }

    @Override
    public void pay(Invoice invoice) {
        account.pay(invoice);
    }
}
