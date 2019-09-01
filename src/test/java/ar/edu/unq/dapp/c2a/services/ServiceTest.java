package ar.edu.unq.dapp.c2a.services;

import ar.edu.unq.dapp.c2a.model.EntityTest;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

public abstract class ServiceTest extends EntityTest {

    protected OrderDAO getOrderDAOMock() {
        OrderDAO orderDAO = Mockito.mock(OrderDAO.class);
        Mockito.when(orderDAO.save(Mockito.anyObject())).thenAnswer((Answer<Order>) invocation -> {
            Object[] args = invocation.getArguments();
            return (Order) args[0];
        });
        return orderDAO;
    }

    protected MenuDAO getMenuDAOMock() {
        MenuDAO menuDAO = Mockito.mock(MenuDAO.class);

        Mockito.when(menuDAO.get(aMenuId())).thenReturn(aMenu());

        return menuDAO;
    }

    protected ClientDAO getClientDAOMock() {
        ClientDAO clientDAO = Mockito.mock(ClientDAO.class);

        Mockito.when(clientDAO.get(aClientId())).thenReturn(aClient());

        return clientDAO;
    }
}
