package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import java.util.List;

public interface Account extends Entity {
    MonetaryAmount getBalance();

    void add(MonetaryAmount aMonetaryAmount);

    List<Statement> getStatements();

    void pay(Invoice invoice);
}
