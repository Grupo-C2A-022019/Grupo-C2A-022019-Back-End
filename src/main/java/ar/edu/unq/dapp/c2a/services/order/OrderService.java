package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;

import java.io.Serializable;
import java.util.Calendar;

public interface OrderService {
    Order orderMenu(Serializable clientId, Serializable menuId, Integer amount, String deliveryType, Calendar deliveryAppointment, Double clientLat, Double clientLng);
}
