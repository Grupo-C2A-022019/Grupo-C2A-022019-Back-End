package ar.edu.unq.dapp.c2a.model.client;

import ar.edu.unq.dapp.c2a.model.Builder;
import ar.edu.unq.dapp.c2a.model.account.Account;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.model.profile.Profile;
import ar.edu.unq.dapp.c2a.model.profile.ProfileBuilder;
import ar.edu.unq.dapp.c2a.model.profile.UserProfile;
import ar.edu.unq.dapp.c2a.model.profile.UserProfileBuilder;

import javax.money.Monetary;
import java.util.ArrayList;

public class ClientBuilder implements Builder<Client> {

    private UserProfileBuilder profileBuilder = new UserProfileBuilder();

    private Long id;
    private Account account = new Account(
            Monetary.getDefaultAmountFactory()
                    .setNumber(0)
                    .setCurrency("ARS")
                    .create(),
            new ArrayList<>()
    );

    public Client build() {
        Client instance = new Client(account,profileBuilder.build());
        instance.setId(id);
        return instance;
    }

    public ClientBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ClientBuilder withAccount(Account anAcount) {
        this.account = anAcount;
        return this;
    }

    public ClientBuilder withName(String name) {
        profileBuilder.withName(name);
        return this;
    }

    public ClientBuilder withLastName(String lastname) {
        profileBuilder.withLastName(lastname);
        return this;
    }

    public ClientBuilder withEmail(String email) {
        profileBuilder.withEmail(email);
        return this;
    }

    public ClientBuilder withTelephone(String telephone) {
        profileBuilder.withTelephone(telephone);
        return this;
    }

    public ClientBuilder withImage(String image) {
        profileBuilder.withImage(image);
        return this;
    }
}
