package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class OrdersController {
    private final OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Collection<Order> getOrders() {
        // TODO: replace with  actual implementation
        Integer clientId = 1;

        Collection<Order> orders = orderService.getClientOrders(clientId);

        // TODO: map data to DTO
        return orders;
    }
}
