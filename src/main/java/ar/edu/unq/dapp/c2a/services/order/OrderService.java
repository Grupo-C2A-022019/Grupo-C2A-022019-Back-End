package ar.edu.unq.dapp.c2a.services.order;

import java.util.Calendar;
import java.util.Collection;

public interface OrderService {
    OrderDTO orderMenu(Long clientId, Long menuId, Integer amount, String deliveryType, Calendar deliveryAppointment, Double clientLat, Double clientLng);

    Collection<OrderDTO> getClientOrders(Long clientId);
}
