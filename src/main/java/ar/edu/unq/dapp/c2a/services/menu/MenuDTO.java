package ar.edu.unq.dapp.c2a.services.menu;

import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.persistence.money.MonetaryAmountConverter;

import javax.money.MonetaryAmount;

public class MenuDTO {
    private final Menu menu;

    MenuDTO(Menu menu) {
        this.menu = menu;
    }

    public long getId() {
        return menu.getId();
    }

    public Long getBusiness() {
        return menu.getBusiness().getId();
    }

    public String getListPrice() {
        return menu.getListPrice().toString();
    }

    public String getDiscountPrice() {
        MonetaryAmount monetaryAmount = menu.getDiscountPrice();
        return monetaryAmount != null ? monetaryAmount.toString() : null;
    }
}
