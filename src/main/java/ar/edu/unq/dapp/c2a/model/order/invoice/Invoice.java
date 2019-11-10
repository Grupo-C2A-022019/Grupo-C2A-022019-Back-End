package ar.edu.unq.dapp.c2a.model.order.invoice;

import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Invoice {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public abstract MonetaryAmount getTotal();

    @Transient
    public abstract String getDescription();
}
