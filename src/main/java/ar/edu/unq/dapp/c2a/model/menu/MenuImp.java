package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.EntityImp;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.order.Order;

public class MenuImp extends EntityImp implements Menu {
    private Business business;

    public MenuImp(Business business) {
        super();
        this.business = business;
    }

    @Override
    public Order orderBy(Client client) {
        return business.placeOrder(this, client);
    }
}
