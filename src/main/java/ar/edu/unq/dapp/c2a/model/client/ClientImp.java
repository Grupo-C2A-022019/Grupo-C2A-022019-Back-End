package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;

public class ClientImp extends EntityImp implements Client {
    @Override
    public Order order(Menu menu) {
        return new OrderBuilder().withClient(this).withMenu(menu).build();
    }
}
