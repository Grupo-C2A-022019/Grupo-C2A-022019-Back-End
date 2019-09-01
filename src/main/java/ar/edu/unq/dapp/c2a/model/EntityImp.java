package ar.edu.unq.dapp.c2a.model;

import java.io.Serializable;

public class EntityImp implements Entity {
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
