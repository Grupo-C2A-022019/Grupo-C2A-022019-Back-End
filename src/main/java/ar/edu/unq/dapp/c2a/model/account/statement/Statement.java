package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.model.Entity;

import javax.money.MonetaryAmount;

public interface Statement extends Entity {
    MonetaryAmount getBalance(MonetaryAmount currentBalance);
}
