package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryAppointment;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.model.order.invoice.InvoiceBuilder;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;

import javax.money.MonetaryAmount;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@javax.persistence.Entity(name = "orden")
public class Order {

    @OneToOne(cascade = CascadeType.ALL)
    private DeliveryAppointment deliveryAppointment;
    @OneToOne(cascade = CascadeType.ALL)
    private Client client;
    @OneToOne(cascade = CascadeType.ALL)
    private Menu menu;
    private Integer amount;
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Invoice invoice;

    public Order() {
    }

    public Order(Client client, Menu menu, Integer amount, DeliveryAppointment deliveryAppointment) {
        super();
        this.client = client;
        this.menu = menu;
        this.amount = amount;
        this.deliveryAppointment = deliveryAppointment;
    }

    public DeliveryAppointment getDeliveryAppointment() {
        return deliveryAppointment;
    }

    public void setDeliveryAppointment(DeliveryAppointment deliveryAppointment) {
        this.deliveryAppointment = deliveryAppointment;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public MonetaryAmount getPrice() {
        return menu.getPriceForOrder(this);
    }

    public Invoice pay() throws AlreadyPaidException {
        if (this.invoice != null) {
            throw new AlreadyPaidException(this);
        }

        this.invoice = new InvoiceBuilder().forOrder(this).build();

        client.pay(invoice);

        return this.invoice;
    }

    public MonetaryAmount getDeliveryPrice() {
        return this.getMenu().getBusiness().getDeliveryPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
