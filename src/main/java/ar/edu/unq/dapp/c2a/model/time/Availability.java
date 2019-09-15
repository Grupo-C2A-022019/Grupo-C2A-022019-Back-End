package ar.edu.unq.dapp.c2a.model.time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public interface Availability {

    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);

    boolean isAvailableAt(Calendar date);
}
