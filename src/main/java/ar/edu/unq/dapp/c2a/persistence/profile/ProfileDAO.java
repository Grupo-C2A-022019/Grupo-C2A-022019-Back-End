package ar.edu.unq.dapp.c2a.persistence.profile;

import ar.edu.unq.dapp.c2a.model.profile.Profile;
import ar.edu.unq.dapp.c2a.model.profile.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDAO extends CrudRepository<Profile, Long> {

    UserProfile findByClient_Id(Long clientProfileId);
}
