package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;

public interface Order extends Entity {
    Entity getClient();

    Menu getMenu();

    Integer getAmount();

    MonetaryAmount getPrice();

    Invoice pay() throws AlreadyPaidException;
}
