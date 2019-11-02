package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.money.Monetary;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class PreloadDataController {

    private final OrderDAO orderDAO;
    private final MenuDAO menuDAO;

    @Autowired
    public PreloadDataController(OrderDAO orderDAO, MenuDAO menuDAO) {
        this.orderDAO = orderDAO;
        this.menuDAO = menuDAO;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/preload"
    )
    public void preloadData() {
        Business abusiness = new BusinessBuilder().build();
        Client aclient = new ClientBuilder().build();


        Menu amenu1 = new MenuBuilder().withName("Juan1")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu2 = new MenuBuilder().withName("Juan2")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu3 = new MenuBuilder().withName("Juan3")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu4 = new MenuBuilder().withName("Juan4")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu5 = new MenuBuilder().withName("Juan5")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu6 = new MenuBuilder().withName("Juan6")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu7 = new MenuBuilder().withName("Juan7")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Menu amenu8 = new MenuBuilder().withName("Juan8")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Order anyOrder = new OrderBuilder().withAmount(100).withClient(aclient).withMenu(amenu1).build();

        orderDAO.save(
                anyOrder
        );

        List<Menu> Menus = new ArrayList<Menu>();
        Menus.add(amenu1);
        Menus.add(amenu2);
        Menus.add(amenu3);
        Menus.add(amenu4);
        Menus.add(amenu5);
        Menus.add(amenu6);
        Menus.add(amenu7);
        Menus.add(amenu8);
        menuDAO.saveAll(Menus);
    }
}
