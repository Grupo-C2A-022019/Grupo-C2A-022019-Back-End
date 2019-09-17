package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@javax.persistence.Entity(name = "orden")
public interface Order {

    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    @ManyToOne
    Client getClient();

    void setClient(Client client);

    @ManyToOne
    Menu getMenu();

    void setMenu(Menu menu);

    Integer getAmount();

    void setAmount(Integer amount);

    @Transient
    MonetaryAmount getPrice();

    Invoice pay() throws AlreadyPaidException;

    @Transient
    MonetaryAmount getDeliveryPrice();
}
