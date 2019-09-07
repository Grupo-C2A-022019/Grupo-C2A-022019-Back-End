package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;

public class OrderInvoice implements Invoice {
    private final MonetaryAmount total;

    public OrderInvoice(Order order) {
        this.total = order.getPrice();
    }

    @Override
    public MonetaryAmount getTotal() {
        return total;
    }
}
