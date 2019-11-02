package ar.edu.unq.dapp.c2a.services.profile;

import ar.edu.unq.dapp.c2a.persistence.profile.ProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImp implements ProfileService {

    private final ProfileDAO profileDAO;

    @Autowired
    public ProfileServiceImp(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    @Override
    public ProfileDTO getClientProfile(Long profileId) {
        return new ProfileDTO(profileDAO.findByClient_Id(profileId));
    }
}
