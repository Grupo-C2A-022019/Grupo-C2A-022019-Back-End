package ar.edu.unq.dapp.c2a.model.client.rating;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;

import javax.persistence.*;


@Entity
public class Rating{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Menu menu;
    @ManyToOne
    private Client client;
    private Rate rate;

    public Rating(){}

    public Rating(Client client, Rate rate, Menu menu){
        setClient(client);
        setMenu(menu);
        setRate(rate);
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
}
