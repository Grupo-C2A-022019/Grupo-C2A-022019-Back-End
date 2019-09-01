package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;

import java.io.Serializable;

public class OrderServiceImp implements OrderService {

    private final OrderDAO orderDAO;
    private final ClientDAO clientDAO;
    private final MenuDAO menuDAO;

    public OrderServiceImp(OrderDAO orderDAO, ClientDAO clientDAO, MenuDAO menuDAO) {
        this.orderDAO = orderDAO;
        this.clientDAO = clientDAO;
        this.menuDAO = menuDAO;
    }

    @Override
    public Order orderMenu(Serializable clientId, Serializable menuId) {
        Client client = clientDAO.get(clientId);
        Menu menu = menuDAO.get(menuId);

        Order order = client.order(menu);
        orderDAO.save(order);

        return order;
    }
}
