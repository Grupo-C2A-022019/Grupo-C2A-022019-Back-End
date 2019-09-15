package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public interface PricingSchema {

    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    MonetaryAmount getPrice(Order order);
}
