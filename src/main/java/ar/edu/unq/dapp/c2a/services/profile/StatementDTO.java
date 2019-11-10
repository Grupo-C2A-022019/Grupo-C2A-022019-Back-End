package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.model.account.statement.Statement;

import javax.money.MonetaryAmount;

public class StatementDTO {
    private final Long id;
    private final String description;
    private final MonetaryAmount amount;

    public StatementDTO(Statement statement) {
        this.id = statement.getId();
        this.amount = statement.getAmount();
        this.description = statement.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }
}
