package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;


@Entity
public class OrderInvoice extends Invoice {
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount menuTotal;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount deliveryTotal;

    public OrderInvoice() {
    }

    public OrderInvoice(Order order) {
        this.menuTotal = order.getPrice();
        this.deliveryTotal = order.getDeliveryPrice();
    }

    @Override
    @Transient
    public MonetaryAmount getTotal() {
        return menuTotal.add(deliveryTotal);
    }

    MonetaryAmount getMenuTotal() {
        return menuTotal;
    }

    void setMenuTotal(MonetaryAmount menuTotal) {
        this.menuTotal = menuTotal;
    }

    MonetaryAmount getDeliveryTotal() {
        return deliveryTotal;
    }

    void setDeliveryTotal(MonetaryAmount deliveryTotal) {
        this.deliveryTotal = deliveryTotal;
    }
}
