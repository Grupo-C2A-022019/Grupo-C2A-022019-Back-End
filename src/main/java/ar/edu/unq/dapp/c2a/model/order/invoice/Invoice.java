package ar.edu.unq.dapp.c2a.model.order.invoice;

import javax.money.MonetaryAmount;

public interface Invoice {
    MonetaryAmount getTotal();
}
