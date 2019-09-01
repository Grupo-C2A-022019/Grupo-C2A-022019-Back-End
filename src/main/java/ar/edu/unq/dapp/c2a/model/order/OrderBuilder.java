package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.Entity;

import java.io.Serializable;

public class OrderBuilder implements Builder<Order> {
    private Serializable clientId;
    private Serializable menuId;

    @Override
    public Order build() {
        Entity client = new Entity() {
            @Override
            public Serializable getId() {
                return clientId;
            }
        };

        Entity menu = new Entity() {
            @Override
            public Serializable getId() {
                return menuId;
            }
        };

        return new Order() {
            @Override
            public Entity getClient() {
                return client;
            }

            @Override
            public Entity getMenu() {
                return menu;
            }

            @Override
            public Serializable getId() {
                return null;
            }
        };
    }

    public OrderBuilder withClient(Serializable clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderBuilder withMenu(Serializable menuId) {
        this.menuId = menuId;
        return this;
    }
}
