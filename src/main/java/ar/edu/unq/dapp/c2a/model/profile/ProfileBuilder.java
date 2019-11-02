package ar.edu.unq.dapp.c2a.model.profile;

import ar.edu.unq.dapp.c2a.model.Builder;

public abstract class ProfileBuilder<T extends Profile> implements Builder<T> {
    private String name;
    private String image;
    private String telephone;
    private String email;

    public ProfileBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProfileBuilder withImage(String image) {
        this.image = image;
        return this;
    }

    public ProfileBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public ProfileBuilder withTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    protected void setValues(BusinessProfile instance) {
        instance.setName(name);
        instance.setImage(image);
        instance.setEmail(email);
        instance.setTelephone(telephone);
    }
}
