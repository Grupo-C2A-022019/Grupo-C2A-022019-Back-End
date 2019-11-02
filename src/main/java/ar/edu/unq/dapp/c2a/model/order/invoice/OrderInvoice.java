package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class OrderInvoice extends Invoice {
    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount menuTotal;
    @Convert(converter = MonetaryAmountConverter.class)
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
