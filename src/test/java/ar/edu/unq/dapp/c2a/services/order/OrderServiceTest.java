package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import ar.edu.unq.dapp.c2a.services.ServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest extends ServiceTest {

    private OrderService orderService;
    private OrderDAO orderDAO;

    @Before
    public void instantiateService() {
        orderDAO = getOrderDAOMock();
        ClientDAO clientDAO = getClientDAOMock();
        MenuDAO menuDAO = getMenuDAOMock();
        orderService = new OrderServiceImp(orderDAO, clientDAO, menuDAO);
    }

    @Test
    public void shouldCreateAnOrderWhenAnUserOrdersAMenu() {
        Serializable anyClientId = aClientId();
        Serializable anyMenuId = aMenuId();

        Order order = orderService.orderMenu(anyClientId, anyMenuId);

        assertEquals(order.getClient().getId(), anyClientId);
        assertEquals(order.getMenu().getId(), anyMenuId);
    }

    @Test
    public void shouldSaveOrderWhenItIsCreated() {
        Serializable anyClientId = aClientId();
        Serializable anyMenuId = aMenuId();

        Order order = orderService.orderMenu(anyClientId, anyMenuId);

        Mockito.verify(orderDAO).save(order);
    }
}
