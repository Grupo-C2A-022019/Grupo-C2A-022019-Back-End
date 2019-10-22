package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
