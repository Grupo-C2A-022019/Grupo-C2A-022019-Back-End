package ar.edu.unq.dapp.c2a.model.business;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.profile.BusinessProfileBuilder;

public class BusinessBuilder implements Builder<Business> {
    private BusinessProfileBuilder profileBuilder = new BusinessProfileBuilder();

    public Business build() {
        return new Business(profileBuilder.build());
    }

    public BusinessBuilder withName(String name) {
        profileBuilder.withName(name);
        return this;
    }

    public BusinessBuilder withDescription(String description) {
        profileBuilder.withDescription(description);
        return this;
    }

    public BusinessBuilder withImg(String image) {
        profileBuilder.withImage(image);
        return this;
    }

    public BusinessBuilder withUrlServ(String urlServ) {
        profileBuilder.withUrl(urlServ);
        return this;
    }

    public BusinessBuilder withEmail(String email) {
        profileBuilder.withEmail(email);
        return this;
    }

    public BusinessBuilder withSchedule(String schedule) {
        profileBuilder.withSchedule(schedule);
        return this;
    }

    public BusinessBuilder withTelephone(String tel) {
        profileBuilder.withTelephone(tel);
        return this;
    }
}
