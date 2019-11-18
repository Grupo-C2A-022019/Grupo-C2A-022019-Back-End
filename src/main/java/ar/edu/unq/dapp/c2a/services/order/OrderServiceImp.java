package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.exceptions.client.ClientNotFound;
import ar.edu.unq.dapp.c2a.exceptions.menu.MenuNotFound;
import ar.edu.unq.dapp.c2a.exceptions.order.OrderNotFound;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderDAO orderDAO;
    private final ClientDAO clientDAO;
    private final MenuDAO menuDAO;

    @Autowired
    public OrderServiceImp(OrderDAO orderDAO, ClientDAO clientDAO, MenuDAO menuDAO) {
        this.orderDAO = orderDAO;
        this.clientDAO = clientDAO;
        this.menuDAO = menuDAO;
    }

    @Override
    public OrderDTO orderMenu(
            Long clientId,
            Long menuId,
            Integer amount,
            String deliveryType,
            Calendar deliveryAppointment,
            Double clientLat,
            Double clientLng
    ) throws ClientNotFound, MenuNotFound {
        Client client = clientDAO.findById(clientId).orElseThrow(() -> new ClientNotFound(clientId));
        Menu menu = menuDAO.findById(menuId).orElseThrow(() -> new MenuNotFound(menuId));

        Order order = client.order(menu, amount, DeliveryType.valueOf(deliveryType), deliveryAppointment, new Location(clientLat, clientLng));
        orderDAO.save(order);

        return new OrderDTO(order);
    }

    @Override
    public Collection<OrderDTO> getClientOrders(Long clientId) {
        Iterable<Order> iterable = orderDAO.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).map(OrderDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrder(Long orderId) {
        Order order = orderDAO.findById(orderId).orElseThrow(() -> new OrderNotFound(orderId));
        return new OrderDTO(order);
    }
}
