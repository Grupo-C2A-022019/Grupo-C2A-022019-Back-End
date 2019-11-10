package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.exceptions.client.ClientNotFound;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientServiceImp implements ClientService {

    private final ClientDAO clientDAO;

    @Autowired
    public ClientServiceImp(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public ClientDTO getClientProfile(Long profileId) {
        return new ClientDTO(clientDAO.findById(profileId).orElseThrow(() -> new ClientNotFound(profileId)));
    }

    @Override
    public List<StatementDTO> getAccountStatements(Long clientId) {
        return clientDAO.findById(clientId).orElseThrow(() -> new ClientNotFound(clientId))
                .getAccount()
                .getStatements()
                .stream()
                .map(StatementDTO::new)
                .collect(Collectors.toList());
    }
}
