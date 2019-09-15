package ar.edu.unq.dapp.c2a.model.client.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public interface Rating {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);
}
