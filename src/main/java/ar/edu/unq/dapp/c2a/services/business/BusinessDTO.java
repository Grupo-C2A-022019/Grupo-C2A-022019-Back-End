package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.model.business.Business;

public class BusinessDTO {
    private Long id;
    private String name;
    private String description;
    private String img;
    private String urlServ;
    private String email;
    private String schedule;
    private String telephone;

    public BusinessDTO(Business business) {
        this(
                business.getId(),
                business.getName(),
                business.getDescription(),
                business.getImage(),
                business.getUrlServ(),
                business.getEmail(),
                business.getSchedule(),
                business.getTelephone()//TODO
        );
    }

    public BusinessDTO(Long id, String name, String description, String img, String urlServ, String email, String schedule, String tel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.urlServ = urlServ;
        this.email = email;
        this.schedule = schedule;
        this.telephone = tel;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImg() {
        return this.img;
    }

    public String getUrlServ() {
        return this.urlServ;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}