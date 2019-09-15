package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;


public class OrderDTO {
    private final Order order;

    OrderDTO(Order order) {
        this.order = order;
    }

    public Long getId() {
        return order.getId();
    }

    public Long getClient() {
        return order.getClient().getId();
    }

    public Long getMenu() {
        return order.getMenu().getId();
    }

    public Integer getAmount() {
        return order.getAmount();
    }
}
