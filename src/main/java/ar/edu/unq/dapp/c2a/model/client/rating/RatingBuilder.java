package ar.edu.unq.dapp.c2a.model.client.rating;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

public class RatingBuilder implements Builder<Rating> {
    private Rate rate;
    private Menu menu;

    
    public Rating build() {
        return new Rating();
    }

    public RatingBuilder withRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public RatingBuilder withMenu(Menu aMenu) {
        this.menu = aMenu;
        return this;
    }
}
