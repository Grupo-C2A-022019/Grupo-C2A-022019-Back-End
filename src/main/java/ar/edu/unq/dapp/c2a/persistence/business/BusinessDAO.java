package ar.edu.unq.dapp.c2a.persistence.business;

import ar.edu.unq.dapp.c2a.model.business.Business;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessDAO extends org.springframework.data.repository.CrudRepository<Business, java.io.Serializable> {
}
