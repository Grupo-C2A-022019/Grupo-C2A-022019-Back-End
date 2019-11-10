package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
public class AcreditationStatement extends Statement {

    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount monetaryAmount;
    private String description;

    public AcreditationStatement() {
    }

    public AcreditationStatement(MonetaryAmount monetaryAmount, String description) {
        this.monetaryAmount = monetaryAmount;
        this.description = description;
    }

    public MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    @Transient
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.add(monetaryAmount);
    }

    @Override
    public MonetaryAmount getAmount() {
        return monetaryAmount;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
