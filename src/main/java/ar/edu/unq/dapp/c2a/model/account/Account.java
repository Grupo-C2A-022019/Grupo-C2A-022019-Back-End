package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@javax.persistence.Entity
public interface Account {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    @Transient
    MonetaryAmount getBalance();

    void add(MonetaryAmount aMonetaryAmount);

    @OneToMany
    List<Statement> getStatements();

    void setStatements(List<Statement> statements);

    void pay(Invoice invoice);
}
