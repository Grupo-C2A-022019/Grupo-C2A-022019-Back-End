package ar.edu.unq.dapp.c2a.model.menu;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.geo.Location;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryType;

import javax.money.MonetaryAmount;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import java.util.Calendar;

@javax.persistence.Entity
public interface Menu {

    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    Order orderBy(Client client, Integer amount, DeliveryType deliveryType, Calendar deliveryAppointment, Location customLocation);

    boolean isAvailableAt(Calendar aLaterDate);

    MonetaryAmount getPriceForOrder(Order order);

    @Transient
    int getAmountOfPendigs();

    @OneToOne
    Business getBusiness();

    void setBusiness(Business business);
}
