package ar.edu.unq.dapp.c2a.model.order.invoice;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public interface Invoice {
    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    @Transient
    MonetaryAmount getTotal();
}
