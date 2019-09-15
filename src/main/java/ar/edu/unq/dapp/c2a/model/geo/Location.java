package ar.edu.unq.dapp.c2a.model.geo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public interface Location {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);
}
