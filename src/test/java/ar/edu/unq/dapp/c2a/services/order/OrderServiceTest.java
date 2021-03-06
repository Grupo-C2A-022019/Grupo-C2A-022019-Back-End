package ar.edu.unq.dapp.c2a.services.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest extends EntityTest {

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
        OrderDTO order = orderService.orderMenu(
                aClientId(),
                aMenuId(),
                aAmount(),
                aDeliveryType().name(),
                aTime(),
                aLat(),
                aLng()
        );

        assertEquals(aClientId(), order.getClientId());
        assertEquals(aMenuId(), order.getMenuId());
        assertEquals(aAmount(), order.getAmount());
    }

    @Test
    public void shouldSaveOrderWhenItIsCreated() {
        Long anyClientId = aClientId();
        Long anyMenuId = aMenuId();

        orderService.orderMenu(anyClientId, anyMenuId, aAmount(), aDeliveryType().name(), aTime(), aLat(), aLng());

        Mockito.verify(orderDAO, Mockito.times(1)).save(Mockito.any(Order.class));
    }
}
