package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.Entity;

public interface Order extends Entity {
    Entity getClient();

    Entity getMenu();
}
