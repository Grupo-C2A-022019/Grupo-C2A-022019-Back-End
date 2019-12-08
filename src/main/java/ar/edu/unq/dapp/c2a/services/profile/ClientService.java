package ar.edu.unq.dapp.c2a.services.profile;

import javax.money.MonetaryAmount;
import java.util.List;

public interface ClientService {
    ClientDTO getClientProfile(Long profileId);

    List<StatementDTO> getAccountStatements(Long clientId);

    void addClientCredit(Long clientId, MonetaryAmount credit);
}
