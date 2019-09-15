package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class PlainFeePricingSchema implements PricingSchema {
    private final MonetaryAmount price;
    @Id
    @GeneratedValue
    private Long id;

    public PlainFeePricingSchema(MonetaryAmount price) {
        this.price = price;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public MonetaryAmount getPrice(Order order) {
        return price.multiply(order.getAmount());
    }
}
