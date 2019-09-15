package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AcreditationStatement implements Statement {

    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount monetaryAmount;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Serializable id;

    public AcreditationStatement(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    @Override
    public Serializable getId() {
        return this.id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    @Override
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.add(monetaryAmount);
    }
}
