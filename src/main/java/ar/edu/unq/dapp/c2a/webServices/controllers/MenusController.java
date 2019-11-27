package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.aspects.AspectExample;
import ar.edu.unq.dapp.c2a.aspects.authorization.Authorized;
import ar.edu.unq.dapp.c2a.services.menu.MenuDTO;
import ar.edu.unq.dapp.c2a.services.menu.MenuService;
import ar.edu.unq.dapp.c2a.services.rating.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Authorized({"menu.create"})
    @RequestMapping(
            path = "/menus",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    MenuDTO createMenu(@Valid @RequestBody MenuDTO menu) {
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
                        menu.getDiscountedPrice(),
                        menu.getImg()
                )
        );

        return menu;
    }

    @Authorized({"menu.read"})
    @RequestMapping(
            path = "/menus",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    List<MenuDTO> getMenus(
            @RequestHeader("authorization") String token,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "0") Integer offset
    ) {
        return menuService.getAllMenus(size, offset);
    }

    @Authorized({"menu.read.byId"})
    @RequestMapping(
            path = "/menus/{id}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    MenuDTO getMenuById(@PathVariable Long id) {
        return menuService.getMenu(id);
    }

    @Authorized({"menu.delete"})
    @RequestMapping(
            path = "/menus/{id}",
            method = RequestMethod.DELETE,
            produces = "application/json"
    )
    public @ResponseBody
    Long deleteMenuById(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return id;
    }

    @Authorized({"menu.read"})
    @AspectExample
    @RequestMapping(
            path = "/search",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public @ResponseBody
    List<MenuDTO> getMenusByString(@RequestParam String q) {

        return menuService.getMenusByString(q);
    }

    @AspectExample
    @RequestMapping(
            path = "/menus/{id}/ratings",
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public @ResponseBody
    RatingDTO rateMenu(@PathVariable Long id, @RequestBody RatingDTO rating) {
        Long clientID = 1l;

        return menuService.rateMenu(clientID,rating.getRate(),id);
    }

}