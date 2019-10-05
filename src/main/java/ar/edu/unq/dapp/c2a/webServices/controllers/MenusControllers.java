package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import ar.edu.unq.dapp.c2a.services.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenusControllers {

    private final MenuService menuService;

    @Autowired
    public MenusControllers(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(path = "/menus/recent", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<MenuDTO> getRecentMenus() {
        return menuService.getRecentMenus();
    }
}