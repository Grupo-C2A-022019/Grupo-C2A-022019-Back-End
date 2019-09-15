package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.geo.Location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.Calendar;

@Entity
public class DeliveryAppointmentImp implements DeliveryAppointment {
    @OneToOne
    private final Location location;
    private final Calendar dateTime;
    @Id
    @GeneratedValue
    private Long id;


    public DeliveryAppointmentImp(Location location, Calendar dateTime) {
        this.location = location;
        this.dateTime = dateTime;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
