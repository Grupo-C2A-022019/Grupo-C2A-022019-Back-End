package ar.edu.unq.dapp.c2a.model;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;

import java.io.Serializable;

public abstract class EntityTest {

    protected Serializable aClientId() {
        return "clientId";
    }

    protected Serializable aMenuId() {
        return "menuId";
    }

    protected Business aBusiness() {
        return new BusinessBuilder().build();
    }

    protected Menu aMenu() {
        return new MenuBuilder().withBusiness(aBusiness()).withId(aMenuId()).build();
    }

    protected Client aClient() {
        return new ClientBuilder().withId(aClientId()).build();
    }
}
