package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryAppointment;

public class OrderImp extends EntityImp implements Order {
    private final Client client;
    private final Menu menu;
    private final Integer amount;
    private final DeliveryAppointment deliveryAppointment;

    public OrderImp(Client client, Menu menu, Integer amount, DeliveryAppointment deliveryAppointment) {
        super();
        this.client = client;
        this.menu = menu;
        this.amount = amount;
        this.deliveryAppointment = deliveryAppointment;
    }

    @Override
    public Entity getClient() {
        return client;
    }

    @Override
    public Entity getMenu() {
        return menu;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }
}
