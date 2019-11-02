package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.account.Account;

import javax.money.Monetary;
import java.util.ArrayList;

public class ClientBuilder implements Builder<Client> {
    private Long id;
    private Account account = new Account(
            Monetary.getDefaultAmountFactory()
                    .setNumber(0)
                    .setCurrency("ARS")
                    .create(),
            new ArrayList<>()
    );

    public Client build() {
        Client instance = new Client(account);
        instance.setId(id);
        return instance;
    }

    public ClientBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withAccount(Account anAcount) {
        this.account = anAcount;
        return this;
    }
}
