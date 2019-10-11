package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.category.Category;
import ar.edu.unq.dapp.c2a.exceptions.business.BusinessNotFound;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.persistence.category.CategoryDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MenuServiceImp implements MenuService {

    private final MenuDAO menuDAO;
    private final BusinessDAO businessDao;
    private final CategoryDAO categoryDao;

    @Autowired
    public MenuServiceImp(MenuDAO menuDAO, BusinessDAO businessDao, CategoryDAO categoryDao) {
        this.menuDAO = menuDAO;
        this.businessDao = businessDao;
        this.categoryDao = categoryDao;
    }

    @AspectExample
    @Override
    @Transactional
    public List<MenuDTO> getRecentMenus() {
        return StreamSupport
                .stream(
                        menuDAO.getRecent(Calendar.getInstance())
                                .spliterator(),
                        false)
                .map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long createMenu(
            Long businessId,
            String name,
            String description,
            Collection<Long> categoryIds,
            Calendar startingDate,
            Calendar expirationDate,
            MonetaryAmount listPrice,
            Integer bulkSize,
            MonetaryAmount discountedPrice
    ) {
        Business business = getBusiness(businessId);
        Collection<Category> categories = getCategories(categoryIds);

        return menuDAO.save(
                new MenuBuilder()
                        .withBusiness(business)
                        .withName(name)
                        .withDescription(description)
                        .withCategories(categories)
                        .withStartDate(startingDate)
                        .withExpirationDate(expirationDate)
                        .withFullPrice(listPrice)
                        .withBulkDiscount(bulkSize, discountedPrice)
                        .build()
        ).getId();
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        return StreamSupport
                .stream(
                        menuDAO.findAll().spliterator(),
                        false)
                .map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    private Collection<Category> getCategories(Collection<Long> categoryId) {
        return (Collection<Category>) categoryDao.findAllById(categoryId);
    }

    private Business getBusiness(Long businessId) {
        Optional<Business> maybeBusiness = businessDao.findById(businessId);

        if (!maybeBusiness.isPresent()) {
            throw new BusinessNotFound(businessId);
        }

        return maybeBusiness.get();
    }
}
