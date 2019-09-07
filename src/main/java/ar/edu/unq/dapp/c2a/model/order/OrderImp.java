package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryAppointment;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.model.order.invoice.InvoiceBuilder;

import javax.money.MonetaryAmount;

public class OrderImp extends EntityImp implements Order {
    private final Client client;
    private final Menu menu;
    private final Integer amount;
    private final DeliveryAppointment deliveryAppointment;
    private Invoice invoice;

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
    public Menu getMenu() {
        return menu;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public MonetaryAmount getPrice() {
        return menu.getPriceForOrder(this);
    }

    @Override
    public Invoice pay() throws AlreadyPaidException {
        if(this.invoice != null) {
            throw new AlreadyPaidException(this);
        }

        this.invoice = new InvoiceBuilder().forOrder(this).build();
        return this.invoice;
    }
}
