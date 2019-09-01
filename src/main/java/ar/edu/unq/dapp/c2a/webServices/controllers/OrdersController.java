package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.order.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@RestController
public class OrdersController {
    @RequestMapping(path = "/orders", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Collection<Order> getOrders() {
        // TODO: implement;
        Collection<Order> orders = new ArrayList<>();

        orders.add(
                new Order() {
                    @Override
                    public Entity getClient() {
                        return null;
                    }

                    @Override
                    public Entity getMenu() {
                        return null;
                    }

                    @Override
                    public Integer getAmount() {
                        return null;
                    }

                    @Override
                    public Serializable getId() {
                        return null;
                    }

                    @Override
                    public void setId(Serializable id) {

                    }
                }
        );

        return orders;
    }
}
