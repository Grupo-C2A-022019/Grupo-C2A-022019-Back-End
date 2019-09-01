package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

public class OrderImp extends EntityImp implements Order {
    private final Client client;
    private final Menu menu;

    public OrderImp(Client client, Menu menu) {
        this.client = client;
        this.menu = menu;
    }

    @Override
    public Entity getClient() {
        return client;
    }

    @Override
    public Entity getMenu() {
        return menu;
    }
}
