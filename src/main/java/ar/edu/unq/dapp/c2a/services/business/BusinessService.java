package ar.edu.unq.dapp.c2a.services.business;

import java.util.Collection;

public interface BusinessService {

    Long createBusiness(
     String name,
     String description,
     String img,
     String urlServ,
     String email,
     String hora_y_dia,
     Integer tel
    );

    Collection<BusinessDTO> getOwnerBusinesses(long ownerId);
}
