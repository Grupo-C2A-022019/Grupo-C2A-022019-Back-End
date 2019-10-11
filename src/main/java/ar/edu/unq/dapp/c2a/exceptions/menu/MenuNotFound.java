package ar.edu.unq.dapp.c2a.exceptions.menu;

public class MenuNotFound extends RuntimeException {
    public MenuNotFound(Long id) {
        super("Invalid menu id: " + id);
    }
}
