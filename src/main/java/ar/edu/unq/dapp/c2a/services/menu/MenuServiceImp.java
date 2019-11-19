package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.exceptions.business.BusinessNotFound;
import ar.edu.unq.dapp.c2a.exceptions.menu.MenuNotFound;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.persistence.category.CategoryDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
            MonetaryAmount discountedPrice,
            String img
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
                        .withImg(img)
                        .build()
        ).getId();
    }

    @Override
    public List<MenuDTO> getAllMenus(Integer size, Integer offset) {
        return StreamSupport
                .stream(
                        menuDAO.findAll(PageRequest.of(offset / size, size)).spliterator(),
                        false)
                .map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public MenuDTO getMenu(Long id) {
        Optional<Menu> maybeMenu = menuDAO.findById(id);

        if (!maybeMenu.isPresent()) {
            throw new MenuNotFound(id);
        }

        return new MenuDTO(maybeMenu.get());
    }

    @Override
    public void deleteMenu(Long id) {
        menuDAO.deleteById(id);
    }

    @Override
    public List<MenuDTO> getMenusByString(String searchTerm) {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 4);
        List<Category> categoryList = categoryDao.findCategoryByNameContains(searchTerm);
        List<Menu> resultadosTotales = menuDAO.findMenuByNameContains(searchTerm,firstPageWithTwoElements);
        resultadosTotales.addAll(menuDAO.findMenuByCategories(categoryList,firstPageWithTwoElements));

        return StreamSupport
                .stream(resultadosTotales.spliterator(),
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
