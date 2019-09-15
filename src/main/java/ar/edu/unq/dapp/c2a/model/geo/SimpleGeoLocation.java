package ar.edu.unq.dapp.c2a.model.geo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class SimpleGeoLocation implements Location {
    private Double lat;
    private Double lng;
    @Id
    @GeneratedValue
    private Long id;

    public SimpleGeoLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
