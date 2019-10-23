package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.model.business.Business;

import javax.money.MonetaryAmount;
import java.util.Calendar;
import java.util.Collection;

public class BusinessDTO {
    private Long id;
    private String name;
    private String description;
    private String img;
    private String urlServ;
    private String email;
    private String hora_y_dia;
    private Integer tel;


    public BusinessDTO(Business business) {
        this(
                business.getId(),
                business.getName(),
                business.getDescription(),
                null,
                null,
                null,
                null,
                null//TODO
        );
    }

    public BusinessDTO(Long id, String name, String description, String img, String urlServ, String email, String hora_y_dia, Integer tel) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
        this.urlServ = urlServ;
        this.email = email;
        this.hora_y_dia = hora_y_dia;
        this.tel = tel;
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

    public String getHora_y_dia() {
        return this.hora_y_dia;
    }

    public Integer getTel() {
        return this.tel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}