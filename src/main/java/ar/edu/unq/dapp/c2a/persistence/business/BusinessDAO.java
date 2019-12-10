package ar.edu.unq.dapp.c2a.persistence.business;

import ar.edu.unq.dapp.c2a.model.business.Business;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BusinessDAO extends CrudRepository<Business, Long>, PagingAndSortingRepository<Business,Long> {
    List<Business> findAllByOwnerId(long ownerId);

    List<Business> findBusinessByProfileNameContainsIgnoreCase(String q, Pageable firstPageWithTwoElements);
}
