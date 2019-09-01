package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;

import java.util.Calendar;

public enum DeliveryType {
    HOME_DELIVERY {
        @Override
        public DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location clientLocation) {
            return new DeliveryAppointmentImp(clientLocation, deliveryTime);
        }
    };

    public abstract DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location clientLocation);
}
