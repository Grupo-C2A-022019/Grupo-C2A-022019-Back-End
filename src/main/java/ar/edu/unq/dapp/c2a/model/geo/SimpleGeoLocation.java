package ar.edu.unq.dapp.c2a.model.geo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class SimpleGeoLocation implements Location {
    private Double lat;
    private Double lng;
    @Id
    @GeneratedValue
    private Serializable id;

    public SimpleGeoLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }
}
