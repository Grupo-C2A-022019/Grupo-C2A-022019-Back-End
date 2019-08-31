package ar.edu.unq.dapp.c2a.services;

import ar.edu.unq.dapp.c2a.model.Client;
import ar.edu.unq.dapp.c2a.model.Menu;
import ar.edu.unq.dapp.c2a.model.Order;

public interface OrderService {
    public Order orderMenu(Client client, Menu menu);
}
