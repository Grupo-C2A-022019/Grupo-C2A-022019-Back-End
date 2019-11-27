package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.services.rating.RatingDTO;

import javax.money.MonetaryAmount;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

public interface MenuService {
    List<MenuDTO> getRecentMenus();

    Long createMenu(
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
    );

    List<MenuDTO> getAllMenus(Integer size, Integer offset);

    MenuDTO getMenu(Long id);

    void deleteMenu(Long id);

    RatingDTO rateMenu(Long clientId, Integer rate, Long menuID);

    List<MenuDTO> getMenusByString(String searchTerm);

}
