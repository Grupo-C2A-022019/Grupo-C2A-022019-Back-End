package ar.edu.unq.dapp.c2a.model.client.rating;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

public class RatingBuilder implements Builder<Rating> {
    private Rate rate;
    private Menu menu;
    private Client client;

    
    public Rating build() {
        return new Rating(client,rate,menu);
    }

    public RatingBuilder withRate(Rate rate) {
        this.rate = rate;
        return this;
    }

    public RatingBuilder withMenu(Menu aMenu) {
        this.menu = aMenu;
        return this;
    }

    public RatingBuilder withClient(Client aClient) {
        this.client = aClient;
        return this;
    }

}
