package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;

public class PlainFeePricingSchema implements PricingSchema {
    private final MonetaryAmount price;

    public PlainFeePricingSchema(MonetaryAmount price) {
        this.price = price;
    }

    @Override
    public MonetaryAmount getPrice(Order order) {
        return price.multiply(order.getAmount());
    }
}
