package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.profile.UserProfile;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;

import javax.money.MonetaryAmount;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {
    private String name;
    private String image;
    private String email;
    private String telephone;
    private String address;
    private MonetaryAmount balance;
    private Collection<MenuDTO> ratingPendings;

    public ClientDTO(Client client) {
            setName(client.getFullName());
            setEmail(client.getEmail());
            setImage(client.getImage());
            setAddress(client.getAddress());
            setTelephone(client.getTelephone());
            setBalance(client.getBalance());
            setRatingPendings(client.getRatingPendingMenus().stream().map(MenuDTO::new).collect(Collectors.toList()));

    }


    public Collection<MenuDTO> getRatingPendings() {
        return ratingPendings;
    }

    public void setRatingPendings(Collection<MenuDTO> ratingPendings) {
        this.ratingPendings = ratingPendings;
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
