package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.SimpleGeoLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;

import java.io.Serializable;
import java.util.Calendar;

public class OrderServiceImp implements OrderService {

    private final OrderDAO orderDAO;
    private final ClientDAO clientDAO;
    private final MenuDAO menuDAO;

    public OrderServiceImp(OrderDAO orderDAO, ClientDAO clientDAO, MenuDAO menuDAO) {
        this.orderDAO = orderDAO;
        this.clientDAO = clientDAO;
        this.menuDAO = menuDAO;
    }

    @Override
    public Order orderMenu(Serializable clientId, Serializable menuId, Integer amount, String deliveryType, Calendar deliveryAppointment, Double clientLat, Double clientLng) {
        Client client = clientDAO.get(clientId);
        Menu menu = menuDAO.get(menuId);

        Order order = client.order(menu, amount, DeliveryType.valueOf(deliveryType), deliveryAppointment, new SimpleGeoLocation(clientLat, clientLng));
        orderDAO.save(order);

        return order;
    }
}
