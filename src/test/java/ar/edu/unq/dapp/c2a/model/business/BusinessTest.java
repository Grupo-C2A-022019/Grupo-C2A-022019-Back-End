package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.order.exception.AlreadyPaidException;
import org.junit.Test;

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
    public void aBusinessShouldNotHavePendingOrdersAfterCollecting() throws AlreadyPaidException {
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
    public void aBusinessShouldHaveInvoicesOfCollectedOrders() throws AlreadyPaidException {
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
}
