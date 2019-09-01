package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest extends EntityTest {

    @Test
    public void anOrderShouldBeCreatedWhenAnUserOrdersAMenu() {
        Client client = aClient();
        Menu menu = aMenu();

        Order order = client.order(menu, aAmount(), aDeliveryType(), aTime(), aLocation());

        assertEquals(client, order.getClient());
        assertEquals(menu, order.getMenu());
    }

    @Test
    public void anUserShouldHaveOneOrderAfterOrderingAMenu() {
        Client client = aClient();
        Menu menu = aMenu();

        client.order(menu, aAmount(), aDeliveryType(), aTime(), aLocation());

        assertEquals(1, client.getOrders().size());
    }
}
