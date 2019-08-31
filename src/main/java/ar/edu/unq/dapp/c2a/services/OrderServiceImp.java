package ar.edu.unq.dapp.c2a.services;

import ar.edu.unq.dapp.c2a.model.Client;
import ar.edu.unq.dapp.c2a.model.Menu;
import ar.edu.unq.dapp.c2a.model.Order;

public class OrderServiceImp implements OrderService {
    @Override
    public Order orderMenu(Client client, Menu menu) {
        return new Order() {
            @Override
            public Client getClient() {
                return client;
            }

            @Override
            public Menu getMenu() {
                return menu;
            }
        };
    }
}
