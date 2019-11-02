package ar.edu.unq.dapp.c2a.model.profile;

import javax.persistence.Entity;

@Entity
public class UserProfile extends Profile {
    private String name;
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    String getFullName() {
        return name + " " + "lastName";
    }
}
