package ar.edu.unq.dapp.c2a.model.order.delivery;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;

import java.util.Calendar;

public enum DeliveryType {
    CUSTOM_LOCATION {
        @Override
        public DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location customLocation) {
            return new DeliveryAppointmentImp(customLocation, deliveryTime);
        }
    },
    STORE_PICKUP {
        @Override
        public DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location customLocation) {
            return new DeliveryAppointmentImp(business.getLocation(), deliveryTime);
        }
    },
    HOME_DELIVERY {
        @Override
        public DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location customLocation) {
            return new DeliveryAppointmentImp(client.getLocation(), deliveryTime);
        }
    };

    public abstract DeliveryAppointment getAppointment(Business business, Client client, Calendar deliveryTime, Location customLocation);
}
