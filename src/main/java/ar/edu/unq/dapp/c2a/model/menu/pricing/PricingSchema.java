package ar.edu.unq.dapp.c2a.model.menu.pricing;

import ar.edu.unq.dapp.c2a.model.order.Order;

import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PricingSchema {
    @Id
    @GeneratedValue
    private Long id;

    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public abstract MonetaryAmount getPrice(Order order);
}
