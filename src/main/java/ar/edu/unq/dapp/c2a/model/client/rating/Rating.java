package ar.edu.unq.dapp.c2a.model.client.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Rating{

    @Id
    @GeneratedValue
    private Long id;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
this.id = id;
    }
}
