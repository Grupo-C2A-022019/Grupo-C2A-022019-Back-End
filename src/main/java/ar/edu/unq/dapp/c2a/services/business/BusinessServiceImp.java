package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.exceptions.business.BusinessNotFound;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImp implements BusinessService {
    private final BusinessDAO businessDAO;

    @Autowired
    public BusinessServiceImp(BusinessDAO businessDAO) {
        this.businessDAO = businessDAO;
    }

    @Override
    public Long createBusiness(String name, String description, Long ownerId, String img, String urlServ, String email, String schedule, String tel) {
        // TODO: add business attributes
        return businessDAO.save(
                new BusinessBuilder()
                        .withName(name)
                        .withDescription(description)
                        .withOwnerId(ownerId)
                        .withImg(img)
                        .withEmail(email)
                        .withUrlServ(urlServ)
                        .withSchedule(schedule)
                        .withTelephone(tel)
                        .build()
        ).getId();
    }

    @Override
    public Collection<BusinessDTO> getOwnerBusinesses(long ownerId) {
        return
                businessDAO.findAllByOwnerId(ownerId).stream()
                .map(BusinessDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BusinessDTO getBusiness(Long id) {
        Optional<Business> maybeMenu = businessDAO.findById(id);

        if (!maybeMenu.isPresent()) {
            throw new BusinessNotFound(id);
        }

        return new BusinessDTO(maybeMenu.get());
    }
}
