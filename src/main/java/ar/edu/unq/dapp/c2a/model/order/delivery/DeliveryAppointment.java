package ar.edu.unq.dapp.c2a.model.order.delivery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public interface DeliveryAppointment {

    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);
}
