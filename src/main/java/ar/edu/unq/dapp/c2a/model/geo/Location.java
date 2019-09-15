package ar.edu.unq.dapp.c2a.model.geo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public interface Location {
    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);
}
