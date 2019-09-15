package ar.edu.unq.dapp.c2a.model.account.statement;

import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@javax.persistence.Entity
public interface Statement {
    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    @Convert(converter = MonetaryAmountConverter.class)
    MonetaryAmount getBalance(MonetaryAmount currentBalance);
}
