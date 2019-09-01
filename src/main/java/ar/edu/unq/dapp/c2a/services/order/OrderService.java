package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;

import java.io.Serializable;

public interface OrderService {
    Order orderMenu(Serializable clientId, Serializable menuId);
}
