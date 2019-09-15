package ar.edu.unq.dapp.c2a.model.client.rating;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MenuRating implements Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Serializable id;

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public void setId(Serializable id) {
this.id = id;
    }
}
