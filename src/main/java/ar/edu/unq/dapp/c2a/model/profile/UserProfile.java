package ar.edu.unq.dapp.c2a.model.profile;

import ar.edu.unq.dapp.c2a.model.client.Client;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UserProfile extends Profile {
    @OneToOne(cascade = CascadeType.ALL)
    private Client client;
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
    public String getFullName() {
        return name + " " + "lastName";
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
