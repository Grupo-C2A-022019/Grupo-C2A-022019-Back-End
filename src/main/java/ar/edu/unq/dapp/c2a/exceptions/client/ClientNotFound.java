package ar.edu.unq.dapp.c2a.exceptions.client;

import ar.edu.unq.dapp.c2a.exceptions.EntityNotFound;

public class ClientNotFound extends EntityNotFound {
    public ClientNotFound(Long clientId) {
        super("Invalid client id:" + clientId);
    }
}
