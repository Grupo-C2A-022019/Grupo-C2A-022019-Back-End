package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderDAO orderDAO;
    private ClientDAO clientDAO;
    private MenuDAO menuDAO;

    @Before
    public void instantiateService() {
        orderDAO = getOrderDAOMock();
        clientDAO = getClientDAOMock();
        menuDAO = getMenuDAOMock();
        orderService = new OrderServiceImp(orderDAO, clientDAO, menuDAO);
    }

    @Test
    public void shouldCreateAnOrderWhenAnUserOrdersAMenu() {
        Serializable anyClientId = anyClientId();
        Serializable anyMenuId = anyMenuId();

        Order order = orderService.orderMenu(anyClientId, anyMenuId);

        assertEquals(order.getClient().getId(), anyClientId);
        assertEquals(order.getMenu().getId(), anyMenuId);
    }

    @Test
    public void shouldSaveOrderWhenItIsCreated() {
        Serializable anyClientId = anyClientId();
        Serializable anyMenuId = anyMenuId();

        Order order = orderService.orderMenu(anyClientId, anyMenuId);

        Mockito.verify(orderDAO).save(order);
    }

    private Serializable anyClientId() {
        return "clientId";
    }

    private Serializable anyMenuId() {
        return "menuId";
    }

    private OrderDAO getOrderDAOMock() {
        OrderDAO orderDAO = Mockito.mock(OrderDAO.class);
        Mockito.when(orderDAO.save(Mockito.anyObject())).thenAnswer((Answer<Order>) invocation -> {
            Object[] args = invocation.getArguments();
            return (Order) args[0];
        });
        return orderDAO;
    }

    private MenuDAO getMenuDAOMock() {
        MenuDAO menuDAO = Mockito.mock(MenuDAO.class);

        Mockito.when(menuDAO.get(anyMenuId())).thenReturn(anyMenu());

        return menuDAO;
    }

    private Menu anyMenu() {
        return new MenuBuilder().withId(anyMenuId()).build();
    }

    private ClientDAO getClientDAOMock() {
        ClientDAO clientDAO = Mockito.mock(ClientDAO.class);

        Mockito.when(clientDAO.get(anyClientId())).thenReturn(anyClient());

        return clientDAO;
    }

    private Client anyClient() {
        return new ClientBuilder().withId(anyClientId()).build();
    }
}
