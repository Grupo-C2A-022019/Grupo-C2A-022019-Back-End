package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.geo.Location;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class DeliveryAppointment {
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    private Calendar dateTime;
    @Id
    @GeneratedValue
    private Long id;

    public DeliveryAppointment() {
    }

    public DeliveryAppointment(Location location, Calendar dateTime) {
        this.location = location;
        this.dateTime = dateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
