package ar.edu.unq.dapp.c2a.model.client.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public interface Rating {
    @Id
    @GeneratedValue
    Long getId();

    void setId(Long id);
}
