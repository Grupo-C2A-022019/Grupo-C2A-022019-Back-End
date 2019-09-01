package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.Entity;

import java.io.Serializable;

public class ClientBuilder implements Builder<Client> {
    private Serializable id;

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
}
