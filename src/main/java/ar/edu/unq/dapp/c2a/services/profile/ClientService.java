package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.model.account.statement.Statement;

import java.util.List;

public interface ClientService {
    ClientDTO getClientProfile(Long profileId);

    List<Statement> getAccountStatements(Long clientId);
}
