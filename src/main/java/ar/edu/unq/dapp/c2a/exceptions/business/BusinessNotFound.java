package ar.edu.unq.dapp.c2a.exceptions.business;

public class BusinessNotFound extends RuntimeException {
    public BusinessNotFound(Long businessId) {
        super("Invalid business id:" + businessId);
    }
}
