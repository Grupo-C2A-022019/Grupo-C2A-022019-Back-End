package ar.edu.unq.dapp.c2a.persistence;

import ar.edu.unq.dapp.c2a.model.Entity;

import java.io.Serializable;

public interface GenericDAO<T extends Entity> {

    T get(Serializable id);

    T save(T entity);
}
