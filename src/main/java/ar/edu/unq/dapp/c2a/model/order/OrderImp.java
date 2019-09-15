package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryAppointment;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.model.order.invoice.InvoiceBuilder;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@javax.persistence.Entity
public class OrderImp implements Order {

    @OneToOne
    private final DeliveryAppointment deliveryAppointment;
    @OneToOne
    private Client client;
    @OneToOne
    private Menu menu;
    private Integer amount;
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Invoice invoice;

    public OrderImp(Client client, Menu menu, Integer amount, DeliveryAppointment deliveryAppointment) {
        super();
        this.client = client;
        this.menu = menu;
        this.amount = amount;
        this.deliveryAppointment = deliveryAppointment;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Integer amount) {
this.amount = amount;
    }

    @Override
    public MonetaryAmount getPrice() {
        return menu.getPriceForOrder(this);
    }

    @Override
    public Invoice pay() throws AlreadyPaidException {
        if (this.invoice != null) {
            throw new AlreadyPaidException(this);
        }

        this.invoice = new InvoiceBuilder().forOrder(this).build();

        client.pay(invoice);

        return this.invoice;
    }

    @Override
    public MonetaryAmount getDeliveryPrice() {
        return this.getMenu().getBusiness().getDeliveryPrice();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
