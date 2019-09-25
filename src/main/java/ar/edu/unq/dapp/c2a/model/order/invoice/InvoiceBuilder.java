package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.order.Order;

public class InvoiceBuilder implements Builder<Invoice> {
    private Order order;

    @Override
    public Invoice build() {
        return new OrderInvoice(order);
    }

    public InvoiceBuilder forOrder(Order order) {
        this.order = order;
        return this;
    }
}
