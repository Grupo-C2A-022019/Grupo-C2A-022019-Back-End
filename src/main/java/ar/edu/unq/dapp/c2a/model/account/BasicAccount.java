package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.account.statement.AcreditationStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.InvoicePaymentStatement;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;

import javax.money.MonetaryAmount;
import java.util.List;

public class BasicAccount extends EntityImp implements Account {
    private MonetaryAmount initialBalance;
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
    public void pay(Invoice invoice) {
        statements.add(new InvoicePaymentStatement(invoice));
    }
}
