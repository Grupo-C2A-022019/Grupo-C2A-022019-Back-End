package ar.edu.unq.dapp.c2a.services.business;

import ar.edu.unq.dapp.c2a.aspects.SendMailAnnotation;
import ar.edu.unq.dapp.c2a.exceptions.business.BusinessNotFound;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.order.invoice.Invoice;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
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
        return new BusinessDTO(findById(id));
    }

    @Override
    public List<MenuDTO> getBusinessMenus(Long id) {
        return findById(id)
                .getOfferedMenus()
                .stream()
                .map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
    public void collectAllPendingOrders() {
        for (Business business : businessDAO.findAll()) {
            collectPendingOrders(business);
        }
    }

    // @NotifyOrderPayment
    @SendMailAnnotation
    private Collection<Invoice> collectPendingOrders(Business business) {
        Collection<Invoice> generatedInvoices = business.collectOrders();
        businessDAO.save(business);
        return generatedInvoices;
    }

    private Business findById(Long id) {
        Optional<Business> maybeMenu = businessDAO.findById(id);

        if (!maybeMenu.isPresent()) {
            throw new BusinessNotFound(id);
        }

        return maybeMenu.get();
    }
}
