package ar.edu.unq.dapp.c2a.model.menu;


import ar.edu.unq.dapp.c2a.model.EntityTest;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
