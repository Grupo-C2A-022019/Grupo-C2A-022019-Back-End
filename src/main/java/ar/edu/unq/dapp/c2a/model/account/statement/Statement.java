package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@javax.persistence.Entity
public interface Statement {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    @Convert(converter = MonetaryAmountConverter.class)
    MonetaryAmount getBalance(MonetaryAmount currentBalance);
}
