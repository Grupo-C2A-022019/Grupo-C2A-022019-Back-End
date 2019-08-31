package ar.edu.unq.dapp.c2a.services;

import ar.edu.unq.dapp.c2a.model.Client;
import ar.edu.unq.dapp.c2a.model.Menu;
import ar.edu.unq.dapp.c2a.model.Order;
import ar.edu.unq.dapp.c2a.persistence.OrderDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {

    OrderService orderService;
    OrderDAO orderDAO;

    @Before
    public void instanciateService() {
        orderDAO = Mockito.mock(OrderDAO.class);
        orderService = new OrderServiceImp();
    }

    @Test
    public void shouldCreateAnOrderWhenAnUserOrdersAMenu() {
        Client anyClient = anyClient();
        Menu anyMenu = anyMenu();

        Order order = orderService.orderMenu(anyClient, anyMenu);

        assertEquals(order.getClient(), anyClient);
        assertEquals(order.getMenu(), anyMenu);
    }

    private Client anyClient() {
        return Mockito.mock(Client.class);
    }

    private Menu anyMenu() {
        return Mockito.mock(Menu.class);
    }
}
