package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.account.statement.AcreditationStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.InvoicePaymentStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount initialBalance;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Statement> statements;

    public Account() {
    }

    public Account(MonetaryAmount initialBalance, List<Statement> statements) {
        this.initialBalance = initialBalance;
        this.statements = statements;
    }

    public MonetaryAmount getBalance() {
        MonetaryAmount currentBalance = initialBalance;

        for (Statement statement : statements) {
            currentBalance = statement.getBalance(currentBalance);
        }

        return currentBalance;
    }

    public void add(MonetaryAmount aMonetaryAmount, String description) {
        statements.add(new AcreditationStatement(aMonetaryAmount, description));
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    public void pay(Invoice invoice) {
        statements.add(new InvoicePaymentStatement(invoice));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(MonetaryAmount money) {
        this.initialBalance = money;
    }
}
