package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;

public class BusinessBuilder implements Builder<Business> {

    private String name;
    private String desctiption;

    public Business build() {
        return new Business(
                name,
                desctiption
        );
    }

    public BusinessBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BusinessBuilder withDescription(String description) {
        this.desctiption = description;
        return this;
    }
}
