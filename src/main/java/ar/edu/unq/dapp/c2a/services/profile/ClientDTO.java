package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.profile.UserProfile;

import javax.money.MonetaryAmount;

public class ClientDTO {
    private String name;
    private String image;
    private String email;
    private String telephone;
    private String address;
    private MonetaryAmount balance;

    public ClientDTO(Client client) {
            setName(client.getFullName());
            setEmail(client.getEmail());
            setImage(client.getImage());
            setAddress(client.getAddress());
            setTelephone(client.getTelephone());
            setBalance(client.getBalance());

    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MonetaryAmount getBalance() {
        return balance;
    }

    public void setBalance(MonetaryAmount balance) {
        this.balance = balance;
    }
}
