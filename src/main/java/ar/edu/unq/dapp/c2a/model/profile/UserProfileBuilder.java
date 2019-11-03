package ar.edu.unq.dapp.c2a.model.profile;

import ar.edu.unq.dapp.c2a.model.client.Client;

public class UserProfileBuilder  extends ProfileBuilder<UserProfile>{

    private Client client;
    private String name;
    private String lastName;

    public UserProfileBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserProfileBuilder withClient(Client client) {
        this.client = client;
        return this;
    }

    @Override
    public UserProfile build() {
        UserProfile instance = new UserProfile();
        this.setValues(instance);
        return instance;
    }

    @Override
    protected void setValues(UserProfile instance) {
        super.setValues(instance);
        instance.setName(name);
        instance.setClient(client);
        instance.setLastName(lastName);
    }
}
