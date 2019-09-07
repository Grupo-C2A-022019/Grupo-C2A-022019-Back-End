package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;

import javax.money.MonetaryAmount;

public interface Order extends Entity {
    Entity getClient();

    Entity getMenu();

    Integer getAmount();

    MonetaryAmount getPrice();
}
