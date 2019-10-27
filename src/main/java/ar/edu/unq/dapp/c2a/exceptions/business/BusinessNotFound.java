package ar.edu.unq.dapp.c2a.exceptions.business;

import ar.edu.unq.dapp.c2a.exceptions.EntityNotFound;

public class BusinessNotFound extends EntityNotFound {
    public BusinessNotFound(Long businessId) {
        super("Invalid business id:" + businessId);
    }
}
