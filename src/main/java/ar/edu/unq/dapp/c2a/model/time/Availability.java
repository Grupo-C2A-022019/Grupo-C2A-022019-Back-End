package ar.edu.unq.dapp.c2a.model.time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Calendar;

@Entity
public interface Availability {

    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);

    boolean isAvailableAt(Calendar date);
}
