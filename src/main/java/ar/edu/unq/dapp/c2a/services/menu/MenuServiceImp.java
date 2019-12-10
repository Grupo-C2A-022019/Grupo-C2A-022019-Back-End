package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.exceptions.client.ClientNotFound;
import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.exceptions.business.BusinessNotFound;
import ar.edu.unq.dapp.c2a.exceptions.menu.MenuNotFound;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.rating.Rate;
import ar.edu.unq.dapp.c2a.model.client.rating.Rating;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.persistence.category.CategoryDAO;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.services.rating.RatingDTO;
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
    private final ClientDAO clientDAO;

    @Autowired
    public MenuServiceImp(MenuDAO menuDAO, BusinessDAO businessDao, CategoryDAO categoryDao,ClientDAO clientDAO) {
        this.menuDAO = menuDAO;
        this.businessDao = businessDao;
        this.categoryDao = categoryDao;
        this.clientDAO = clientDAO;
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
    public List<MenuDTO> getMenusByString(String searchTerm, Integer offset, Integer size) {
        Pageable firstPageWithTwoElements = PageRequest.of(offset / size, size);
        List<Category> categoryList = categoryDao.findCategoryByNameContains(searchTerm);
        List<Menu> resultadosTotales = menuDAO.findMenuByNameContains(searchTerm,firstPageWithTwoElements);
        resultadosTotales.addAll(menuDAO.findMenuByCategories(categoryList,firstPageWithTwoElements));

        return StreamSupport
                .stream(resultadosTotales.spliterator(),
                        false)
                .map(MenuDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDTO rateMenu(Long clientId, Integer rate, Long menuId) {
        Client client = clientDAO.findById(clientId).orElseThrow(() -> new ClientNotFound(clientId));
        Menu maybeMenu = menuDAO.findById(menuId).orElseThrow(() -> new MenuNotFound(menuId));;
        Rating rating = client.rate(Rate.values()[rate-1],maybeMenu);
        menuDAO.save(maybeMenu);
        return(new RatingDTO(rating));
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
