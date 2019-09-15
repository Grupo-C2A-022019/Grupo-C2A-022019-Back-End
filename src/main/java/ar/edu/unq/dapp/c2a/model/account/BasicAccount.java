package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.account.statement.AcreditationStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.InvoicePaymentStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BasicAccount implements Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Serializable id;

    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount initialBalance;
    @OneToMany
    private List<Statement> statements;

    BasicAccount(MonetaryAmount initialBalance, List<Statement> statements) {
        this.initialBalance = initialBalance;
        this.statements = statements;
    }

    @Override
    public MonetaryAmount getBalance() {
        MonetaryAmount currentBalance = initialBalance;

        for (Statement statement : statements) {
            currentBalance = statement.getBalance(currentBalance);
        }

        return currentBalance;
    }

    @Override
    public void add(MonetaryAmount aMonetaryAmount) {
        statements.add(new AcreditationStatement(aMonetaryAmount));
    }

    @Override
    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void pay(Invoice invoice) {
        statements.add(new InvoicePaymentStatement(invoice));
    }

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }
}
