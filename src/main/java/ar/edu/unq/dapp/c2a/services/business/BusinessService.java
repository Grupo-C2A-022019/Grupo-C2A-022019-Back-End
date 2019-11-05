package ar.edu.unq.dapp.c2a.services.business;

import java.util.Collection;

public interface BusinessService {

    Long createBusiness(
     String name,
     String description,
     Long ownerId,
     String img,
     String urlServ,
     String email,
     String schedule,
     String tel
    );

    Collection<BusinessDTO> getOwnerBusinesses(long ownerId);

    BusinessDTO getBusiness(Long id);
}
