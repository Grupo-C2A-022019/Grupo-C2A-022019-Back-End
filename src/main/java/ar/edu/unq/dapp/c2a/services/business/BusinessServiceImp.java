package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusinessServiceImp implements BusinessService {
    private final BusinessDAO businessDAO;

    @Autowired
    public BusinessServiceImp(BusinessDAO businessDAO) {
        this.businessDAO = businessDAO;
    }

    @Override
    public Long createBusiness(String name, String description, String img, String urlServ, String email, String hora_y_dia, Integer tel) {
        // TODO: add business attributes
        return businessDAO.save(
                new BusinessBuilder()
                        .withName(name)
                        .withDescription(description)
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
}
