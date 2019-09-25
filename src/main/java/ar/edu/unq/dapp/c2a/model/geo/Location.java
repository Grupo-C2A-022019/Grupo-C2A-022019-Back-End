package ar.edu.unq.dapp.c2a.model.geo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location {
    private Double lat;
    private Double lng;
    @Id
    @GeneratedValue
    private Long id;

    public Location(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
