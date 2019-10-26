package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;

public class BusinessBuilder implements Builder<Business> {

    private String name;
    private String description;
    private String img;
    private String urlServ;
    private String email;
    private String schedule;
    private Integer tel;

    public Business build() {
        return new Business(
                name,
                description
        );
    }

    public BusinessBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BusinessBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
    public BusinessBuilder withImg(String Img) {
        this.img = img;
        return this;
    }
    public BusinessBuilder withUrlServ(String urlServ) {
        this.urlServ = urlServ;
        return this;
    }
    public BusinessBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
    public BusinessBuilder withSchedule(String schedule) {
        this.schedule = schedule;
        return this;
    }
    public BusinessBuilder withTel(Integer tel) {
        this.tel = tel;
        return this;
    }

}
