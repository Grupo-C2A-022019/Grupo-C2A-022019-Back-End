package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import ar.edu.unq.dapp.c2a.services.order.OrderDTO;
import ar.edu.unq.dapp.c2a.services.profile.StatementDTO;

import java.util.Collection;
import java.util.List;

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

    List<MenuDTO> getBusinessMenus(Long id);

    void collectAllPendingOrders();

    List<OrderDTO> getBusinessStatements(Long id);

    List<BusinessDTO> getBusinessByName(String q);
}
