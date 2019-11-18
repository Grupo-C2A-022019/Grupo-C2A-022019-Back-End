package ar.edu.unq.dapp.c2a.exceptions.order;

import ar.edu.unq.dapp.c2a.exceptions.EntityNotFound;

public class OrderNotFound extends EntityNotFound {
    public OrderNotFound(Long id) {
        super("Invalid order id: " + id);
    }
}
