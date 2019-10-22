package ar.edu.unq.dapp.c2a.persistence.business;

import ar.edu.unq.dapp.c2a.model.business.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDAO extends CrudRepository<Business, Long> {
}
