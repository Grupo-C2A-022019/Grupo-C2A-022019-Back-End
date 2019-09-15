package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public interface PricingSchema {

    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    MonetaryAmount getPrice(Order order);
}
