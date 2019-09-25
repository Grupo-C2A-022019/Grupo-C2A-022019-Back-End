package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public abstract class PricingSchema {

    @Id
    @GeneratedValue
    abstract Long getId();

    abstract void setId(Long id);

    abstract MonetaryAmount getPrice(Order order);
}
