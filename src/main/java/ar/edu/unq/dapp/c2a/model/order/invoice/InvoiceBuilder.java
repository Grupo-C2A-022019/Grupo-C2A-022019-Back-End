package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderImp;

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
