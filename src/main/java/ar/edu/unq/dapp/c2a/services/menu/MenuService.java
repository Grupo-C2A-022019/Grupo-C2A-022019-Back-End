package ar.edu.unq.dapp.c2a.services.menu;

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
            MonetaryAmount discountedPrice
    );

    List<MenuDTO> getAllMenus();

    MenuDTO getMenu(Long id);

    void deleteMenu(Long id);

    List<MenuDTO> getMenusByName(String searchTerm);
}
