package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.model.profile.UserProfile;

public class UserProfileDTO {
    private String name;
    private String image;
    private String email;
    private String telephone;
    private String address;

    public UserProfileDTO(UserProfile profile) {
            profile.getFullName();
            setEmail(profile.getEmail());
            setImage(profile.getImage());
            setAddress(profile.getAddress());
            setTelephone(profile.getTelephone());
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
}
