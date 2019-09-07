package ar.edu.unq.dapp.c2a.model.order.exception;

import ar.edu.unq.dapp.c2a.model.order.Order;

public class AlreadyPaidException extends Exception {
    private final Order order;

    public AlreadyPaidException(Order order) {
        this.order = order;
    }
}
