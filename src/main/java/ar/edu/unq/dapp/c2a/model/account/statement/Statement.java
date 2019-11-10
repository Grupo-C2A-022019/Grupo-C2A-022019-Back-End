package ar.edu.unq.dapp.c2a.model.account.statement;

import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Statement {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Transient
    public abstract MonetaryAmount getBalance(MonetaryAmount currentBalance);

    @Transient
    public abstract MonetaryAmount getAmount();

    @Transient
    public abstract String getDescription();
}
