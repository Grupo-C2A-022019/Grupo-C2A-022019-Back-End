package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.geo.Location;

import java.util.Calendar;

public interface DeliveryAppointment {
    Location getLocation();
    Calendar getDateTime();
}
