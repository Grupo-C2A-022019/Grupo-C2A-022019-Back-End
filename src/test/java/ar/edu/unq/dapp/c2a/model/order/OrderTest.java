package ar.edu.unq.dapp.c2a.model.order;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTest extends EntityTest {

    @Test
    public void anOrderForASingleMenuShouldHaveFullPrice() {
        Menu aMenu = aMenuPricedAt(fullPrice());
        Order anOrder = anOrderFor(1, aMenu);

        assertEquals(
                fullPrice(),
                anOrder.getPrice()
        );
    }
}
