package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.Entity;
import ar.edu.unq.dapp.c2a.model.business.Business;

import java.io.Serializable;

public class MenuBuilder implements Builder<Menu> {
    private Serializable id;
    private Business business;

    @Override
    public Menu build() {
        Menu instance = new MenuImp(business);
        instance.setId(id);
        return instance;
    }

    public MenuBuilder withId(Serializable id) {
        this.id = id;
        return this;
    }

    public MenuBuilder withBusiness(Business business) {
        this.business = business;
        return this;
    }
}
