package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.geo.Location;

import java.util.Calendar;

public class DeliveryAppointmentImp implements DeliveryAppointment {
    private final Location location;
    private final Calendar dateTime;

    public DeliveryAppointmentImp(Location location, Calendar dateTime) {
        this.location = location;
        this.dateTime = dateTime;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public Calendar getDateTime() {
        return this.dateTime;
    }
}
