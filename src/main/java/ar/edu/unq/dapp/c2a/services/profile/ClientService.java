package ar.edu.unq.dapp.c2a.services.profile;

import java.util.List;

public interface ClientService {
    ClientDTO getClientProfile(Long profileId);

    List<StatementDTO> getAccountStatements(Long clientId);
}
