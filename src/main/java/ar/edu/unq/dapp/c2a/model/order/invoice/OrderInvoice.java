package ar.edu.unq.dapp.c2a.model.order.invoice;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class OrderInvoice implements Invoice {
    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount menuTotal;
    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount deliveryTotal;
    @Id
    @GeneratedValue
    private Serializable id;

    public OrderInvoice(Order order) {
        this.menuTotal = order.getPrice();
        this.deliveryTotal = order.getDeliveryPrice();
    }

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public MonetaryAmount getTotal() {
        return menuTotal.add(deliveryTotal);
    }
}
