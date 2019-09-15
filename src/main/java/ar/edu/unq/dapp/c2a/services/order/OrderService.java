package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;

import java.util.Calendar;
import java.util.Collection;

public interface OrderService {
    Order orderMenu(Long clientId, Long menuId, Integer amount, String deliveryType, Calendar deliveryAppointment, Double clientLat, Double clientLng);

    Collection<OrderDTO> getClientOrders(Long clientId);
}
