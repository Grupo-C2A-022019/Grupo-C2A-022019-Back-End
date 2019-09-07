package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import org.junit.Test;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.Calendar;

import static org.junit.Assert.*;

public class MenuTest extends EntityTest {

    @Test
    public void aMenuShouldNotBeAvailableAfterExpiration() {
        assertFalse(aMenuThatExpiresAt(aDate()).isAvailableAt(aLaterDate()));
    }

    @Test
    public void aMenuShouldNotBeAvailableBeforePublication() {
        assertFalse(aMenuPublishedAt(aDate()).isAvailableAt(anEarlierDate()));
    }

    @Test
    public void aMenuShouldBeAvailableTheDayOfPublication() {
        assertTrue(aMenuPublishedAt(aDate()).isAvailableAt(aDate()));
    }

    @Test
    public void aMenuShouldBeAvailableUpToTheDayOfExpiration() {
        Calendar expiration = aDate();
        Calendar justBeforeExpiration = (Calendar) expiration.clone();
        justBeforeExpiration.add(Calendar.SECOND, -1);

        assertTrue(aMenuThatExpiresAt(expiration).isAvailableAt(justBeforeExpiration));
    }

    @Test
    public void aMenuWithoutPlacedOrdersShouldHaveFullPrice() {
        assertEquals(
                fullPrice(),
                aMenuPricedAt(fullPrice()).price()
        );
    }

    private Menu aMenuPricedAt(MonetaryAmount fullPrice) {
        return new MenuBuilder().withFullPrice(fullPrice).withStartDate(aDate()).withExpirationDate(aLaterDate()).build();
    }

    private MonetaryAmount fullPrice() {
        return Monetary.getDefaultAmountFactory().setNumber(11.1111).setCurrency("ARS").create();
    }
}
