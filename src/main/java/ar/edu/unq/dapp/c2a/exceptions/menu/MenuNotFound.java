package ar.edu.unq.dapp.c2a.exceptions.menu;

import ar.edu.unq.dapp.c2a.exceptions.EntityNotFound;

public class MenuNotFound extends EntityNotFound {
    public MenuNotFound(Long id) {
        super("Invalid menu id: " + id);
    }
}
