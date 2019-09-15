package ar.edu.unq.dapp.c2a.persistence.client;

import ar.edu.unq.dapp.c2a.model.client.Client;

public interface ClientDAO extends org.springframework.data.repository.CrudRepository<Client, Long> {
}
