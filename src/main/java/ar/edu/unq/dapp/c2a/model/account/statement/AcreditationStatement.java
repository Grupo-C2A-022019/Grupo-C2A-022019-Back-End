package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;


@Entity
public class AcreditationStatement implements Statement {

    @Convert(converter = MonetaryAmountConverter.class)
    private final MonetaryAmount monetaryAmount;
    @Id
    @GeneratedValue
    private Long id;

    public AcreditationStatement(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.add(monetaryAmount);
    }
}
