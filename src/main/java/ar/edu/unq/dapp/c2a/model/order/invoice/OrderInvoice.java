package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
public class OrderInvoice extends Invoice {
    private String description;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount menuTotal;
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount deliveryTotal;

    public OrderInvoice() {
    }

    public OrderInvoice(Order order) {
        this.menuTotal = order.getPrice();
        this.deliveryTotal = order.getDeliveryPrice();
        this.description = order.getMenu().getName();
    }

    @Override
    @Transient
    public MonetaryAmount getTotal() {
        return menuTotal.add(deliveryTotal);
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    void setDescription(String description) {
        this.description = description;
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
