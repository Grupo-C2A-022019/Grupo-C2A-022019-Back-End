package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class BusinessTest extends EntityTest {

    @Test
    public void aBusinessShouldHavePendingOrdersAfterPlacingAnOrder() {
        Menu aMenu = aMenu();
        Business aBusiness = aMenu.getBusiness();
        Client aClient = aClient();

        aBusiness.placeOrder(aMenu, aClient, aAmount(), aDeliveryType(), aTime(), aLocation());

        assertEquals(
                1,
                aBusiness.getPendingOrders().size()
        );
    }

    @Test
    public void aBusinessShouldNotHavePendingOrdersAfterCollecting() {
        Menu aMenu = aMenu();
        Business aBusiness = aMenu.getBusiness();
        Client aClient = aClient();
        aBusiness.placeOrder(aMenu, aClient, aAmount(), aDeliveryType(), aTime(), aLocation());

        aBusiness.collectOrders();

        assertEquals(
                0,
                aBusiness.getPendingOrders().size()
        );
    }

    @Test
    public void aBusinessShouldHaveInvoicesOfCollectedOrders() {
        Menu aMenu = aMenu();
        Business aBusiness = aMenu.getBusiness();
        Client aClient = aClient();
        aBusiness.placeOrder(aMenu, aClient, aAmount(), aDeliveryType(), aTime(), aLocation());

        aBusiness.collectOrders();

        assertEquals(
                1,
                aBusiness.getInvoices().size()
        );
    }

    @Test
    public void aBusinessShouldHaveAnID() {
        Collection<Invoice> pagos = new ArrayList<Invoice>();
        Collection<Order> ordenes = new ArrayList<Order>();
        Menu aMenu = aMenu();
        Business aBusiness = aMenu.getBusiness();
        aBusiness.setInvoices(pagos);
        aBusiness.setPendingOrders(ordenes);

        aBusiness.setId(50L);

        Long IdTest = 50L;
        Long IdMov = aBusiness.getId();


        assertEquals(
                IdTest,
                IdMov
        );
    }


}
