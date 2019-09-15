package ar.edu.unq.dapp.c2a.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public interface Entity {
    @Id
    @GeneratedValue
    Serializable getId();

    void setId(Serializable id);
}
