package ar.edu.unq.dapp.c2a.model.profile;

import javax.persistence.Entity;

@Entity
public class BusinessProfile extends Profile {
    private String name;
    private String description;
    private String urlServ;
    private String schedule;

    public BusinessProfile() {
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlServ() {
        return urlServ;
    }

    public void setUrlServ(String urlServ) {
        this.urlServ = urlServ;
    }

    @Override
    String getFullName() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
