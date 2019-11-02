package ar.edu.unq.dapp.c2a.persistence.profile;

import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDAO  extends org.springframework.data.repository.CrudRepository<Profile, Long>{

    Profile findByClient_Id(Long clientProfileId);
}
