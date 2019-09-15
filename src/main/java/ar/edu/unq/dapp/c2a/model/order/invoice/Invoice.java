package ar.edu.unq.dapp.c2a.model.order.invoice;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
public interface Invoice {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    @Transient
    MonetaryAmount getTotal();
}
