package ar.edu.unq.dapp.c2a.model.geo;

public class SimpleGeoLocation implements Location {
    private Double lat;
    private Double lng;

    public SimpleGeoLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public Double getLat() {
        return lat;
    }

    @Override
    public Double getLng() {
        return lng;
    }
}
