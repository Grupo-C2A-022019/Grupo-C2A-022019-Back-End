package ar.edu.unq.dapp.c2a.model;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {

    @Test
    public void anOrderShouldBeCreatedWhenAnUserOrdersAMenu() {
        Client client = anyClient();
        Menu menu = anyMenu();

        Order order = client.order(menu);

        assertEquals(order.getClient(), client);
        assertEquals(order.getMenu(), menu);
    }

    private Menu anyMenu() {
        return new MenuBuilder().build();
    }

    private Client anyClient() {
        return new ClientBuilder().build();
    }
}
