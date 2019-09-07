package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;

public interface PricingSchema {

    MonetaryAmount getPrice(Order order);
}
