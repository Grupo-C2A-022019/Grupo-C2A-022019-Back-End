package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.exceptions.client.ClientNotFound;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}