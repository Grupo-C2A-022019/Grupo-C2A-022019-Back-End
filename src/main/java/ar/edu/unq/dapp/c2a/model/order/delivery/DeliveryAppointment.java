package ar.edu.unq.dapp.c2a.model.order.delivery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public interface DeliveryAppointment {

    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);
}
