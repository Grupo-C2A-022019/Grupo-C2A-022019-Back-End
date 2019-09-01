package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

public class OrderBuilder implements Builder<Order> {
    private Client client;
    private Menu menu;

    @Override
    public Order build() {
        return new OrderImp(client, menu);
    }

    public OrderBuilder withClient(Client clientId) {
        this.client = clientId;
        return this;
    }

    public OrderBuilder withMenu(Menu menuId) {
        this.menu = menuId;
        return this;
    }
}
