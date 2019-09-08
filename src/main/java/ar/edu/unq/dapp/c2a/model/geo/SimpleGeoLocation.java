package ar.edu.unq.dapp.c2a.model.geo;

public class SimpleGeoLocation implements Location {
    private Double lat;
    private Double lng;

    public SimpleGeoLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
