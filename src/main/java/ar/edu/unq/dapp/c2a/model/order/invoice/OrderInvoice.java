package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;

public class OrderInvoice implements Invoice {
    private final MonetaryAmount menuTotal;
    private final MonetaryAmount deliveryTotal;

    public OrderInvoice(Order order) {
        this.menuTotal = order.getPrice();
        this.deliveryTotal = order.getDeliveryPrice();
    }

    @Override
    public MonetaryAmount getTotal() {
        return menuTotal.add(deliveryTotal);
    }
}
