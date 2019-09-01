package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.Builder;

import java.io.Serializable;

public class MenuBuilder implements Builder<Menu> {
    private Serializable id;

    @Override
    public Menu build() {
        Menu instance = new MenuImp();
        instance.setId(id);
        return instance;
    }

    public MenuBuilder withId(Serializable id) {
        this.id = id;
        return this;
    }
}
