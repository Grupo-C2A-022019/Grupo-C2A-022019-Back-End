package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.services.order.OrderDTO;
import ar.edu.unq.dapp.c2a.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
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
    Collection<OrderDTO> getOrders() {
        // TODO: replace with  actual implementation
        long clientId = 1l;

        return orderService.getClientOrders(clientId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/orders",
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    OrderDTO createOrder(@RequestBody OrderDTO order) {
        // TODO calculate values
        Long clientId = 2L;
        String deliveryType = DeliveryType.CUSTOM_LOCATION.name();
        Calendar deliveryAppointment = Calendar.getInstance();
        deliveryAppointment.add(Calendar.DAY_OF_YEAR, 1);
        Double clientLat = -34.7064966d;
        Double clientLng = -58.280724d;

        return orderService.orderMenu(
                clientId,
                order.getMenuId(),
                order.getAmount(),
                deliveryType,
                deliveryAppointment,
                clientLat,
                clientLng
        );
    }
}
