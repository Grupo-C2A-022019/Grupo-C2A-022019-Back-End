package ar.edu.unq.dapp.c2a.model.menu;


import ar.edu.unq.dapp.c2a.model.EntityTest;
import org.junit.Test;
import org.mockito.internal.matchers.Contains;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MenuTest extends EntityTest {

    @Test
    public void aMenuShouldHaveAName() {
            Menu menu = aMenu();
            
    }

    @Test
    public void aMenuShouldNotBeAvailableAfterExpiration() {
        Menu aMenu = aMenuThatExpiresAt(aDate());

        assertFalse(aMenu.isAvailableAt(aLaterDate()));
    }
}
