package ar.edu.unq.dapp.c2a.services.authorization;

public interface AuthorizationService {
    boolean isAuthorized(String token, String permission);
}
