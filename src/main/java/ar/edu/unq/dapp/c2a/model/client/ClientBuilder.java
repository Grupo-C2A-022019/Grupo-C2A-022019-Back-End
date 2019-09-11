package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.account.Account;

import java.io.Serializable;

public class ClientBuilder implements Builder<Client> {
    private Serializable id;
    private Account account;

    @Override
    public Client build() {
        Client instance = new ClientImp();
        instance.setId(id);
        return instance;
    }

    public ClientBuilder withId(Serializable id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withAccount(Account anAcount) {
        this.account = anAcount;
        return this;
    }
}
