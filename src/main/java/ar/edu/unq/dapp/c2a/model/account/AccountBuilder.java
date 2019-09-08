package ar.edu.unq.dapp.c2a.model.account;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.account.statement.Statement;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.ArrayList;
import java.util.List;

public class AccountBuilder implements Builder<Account> {
    private MonetaryAmount balance = Monetary.getDefaultAmountFactory().setNumber(0).setCurrency("ARS").create();
    private List<Statement> statements = new ArrayList<>();

    @Override
    public Account build() {
        return new BasicAccount(balance, statements);
    }

    public AccountBuilder withBalance(MonetaryAmount balance) {
        this.balance = balance;
        return this;
    }
}
