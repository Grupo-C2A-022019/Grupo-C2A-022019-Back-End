package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    private final Order order;

    OrderDTO(Order order) {
        this.order = order;
    }

    public Serializable getId() {
        return order.getId();
    }

    public Serializable getClient() {
        return order.getClient().getId();
    }

    public Serializable getMenu() {
        return order.getMenu().getId();
    }

    public Serializable getAmount() {
        return order.getAmount();
    }
}
