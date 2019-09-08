package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.EntityImp;

import javax.money.MonetaryAmount;

public class AcreditationStatement extends EntityImp implements Statement {
    private final MonetaryAmount monetaryAmount;

    public AcreditationStatement(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    @Override
    public MonetaryAmount getBalance(MonetaryAmount currentBalance) {
        return currentBalance.add(monetaryAmount);
    }
}
