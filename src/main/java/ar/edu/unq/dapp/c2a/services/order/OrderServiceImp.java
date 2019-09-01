package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;

import java.io.Serializable;

public class OrderServiceImp implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImp(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public Order orderMenu(Serializable clientId, Serializable menuId) {
        return orderDAO.save(new OrderBuilder().withClient(clientId).withMenu(menuId).build());
    }
}
