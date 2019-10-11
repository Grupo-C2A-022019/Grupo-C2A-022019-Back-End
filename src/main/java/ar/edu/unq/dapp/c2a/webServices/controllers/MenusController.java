package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import ar.edu.unq.dapp.c2a.services.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
public class MenusController {

    private final MenuService menuService;

    @Autowired
    public MenusController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(path = "/menus/recent", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<MenuDTO> getRecentMenus() {
        return menuService.getRecentMenus();
    }

    @RequestMapping(
            path = "/menus",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    MenuDTO createMenu(@RequestBody MenuDTO menu) throws ValidationException {
        //TODO add validations

        menu.setId(
                menuService.createMenu(
                        menu.getBusinessId(),
                        menu.getName(),
                        menu.getDescription(),
                        menu.getCategoryIds(),
                        menu.getStartingDate(),
                        menu.getExpirationDate(),
                        menu.getListPrice(),
                        menu.getBulkSize(),
                        menu.getDiscountedPrice()
                )
        );

        return menu;
    }
}