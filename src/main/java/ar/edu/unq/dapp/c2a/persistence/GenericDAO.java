package ar.edu.unq.dapp.c2a.persistence;

import ar.edu.unq.dapp.c2a.model.Entity;

public interface GenericDAO<T extends Entity> {

    T save(T entity);
}
