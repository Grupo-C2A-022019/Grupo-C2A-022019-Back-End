package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.aspects.SendMailAnnotation;
import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.model.profile.*;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import ar.edu.unq.dapp.c2a.services.business.BusinessService;
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
    private final BusinessService businessService;

    @Autowired
    public PreloadDataController(OrderDAO orderDAO, MenuDAO menuDAO,BusinessService businessService) {
        this.orderDAO = orderDAO;
        this.menuDAO = menuDAO;
        this.businessService = businessService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/collect"
    )
    public void collectAll(){
        businessService.collectAllPendingOrders();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/preload"
    )
    public void preloadData() {
        Business abusiness = new BusinessBuilder()
                .withName("El pollo de Peron")
                .withDescription("La milanga al gobierno")
                .withEmail("elgeneral@casarosada.com.ar")
                .withOwnerId(2L)
                .withSchedule("Lun a Vie 19:00hs a 23:59Hs - 17 Oct. Cerrado")
                .withTelephone("011 - 1710 - 1945")
                .withUrlServ("http://www.argentina.gob.ar/")
                .withImg("http://www.laprensa.com.ar/multimedios/imgs/94850_620.jpg")
                .build();

        Calendar now = Calendar.getInstance();
        Client aclient = new ClientBuilder().withName("Tobias")
                .withLastName("Calvento")
                .withEmail("tobiascalvento@hotmail.com")
                .withTelephone("1132823363")
                .withImage("https://www.fundeu.es/wp-content/uploads/2014/09/timelapse-Mario-Castillo.jpg")
                .build();

        Calendar later = Calendar.getInstance();
        later.add(Calendar.YEAR, 1);

        Menu amenu1 = new MenuBuilder().withName("Juan1")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withImg("https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg")
                .withDescription("A nisman lo mato la policia federal Argentina")
                .build();

        Menu amenu2 = new MenuBuilder().withName("Juan2")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("Soy una descripcion estoy re loco")
                .withImg("https://static.independent.co.uk/s3fs-public/thumbnails/image/2016/12/29/16/junk-food-istock-zeljkosantrac.jpg?w968h681")
                .build();

        Menu amenu3 = new MenuBuilder().withName("Juan3")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— ¿Qué le dice un techo a otro?\n" +
                        "\n" +
                        "— Techo de menos.")
                .withImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-O3479jRzzH3_67BJ6EtBrTAmbHnpSTGNMgPjUmuzHbncQeYkDQ&s")
                .build();

        Menu amenu4 = new MenuBuilder().withName("Juan4")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— Hola, ¿está Agustín?\n" +
                        "\n" +
                        "— No, estoy incomodín.")
                .withImg("https://b.zmtcdn.com/data/pictures/4/18892214/0b0adb4f47d79c4535e53fc0c123377d_featured_v2.jpg")
                .build();

        Menu amenu5 = new MenuBuilder().withName("Juan5")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— ¿Dónde cuelga Superman su supercapa?\n" +
                        "\n" +
                        "— En superchero")
                .withImg("https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/erb5zdflgcpuzsjmzlhe")
                .build();

        Menu amenu6 = new MenuBuilder().withName("Juan6")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— ¿Qué le dice una iguana a su hermana gemela?\n" +
                        "\n" +
                        "— Somos iguanitas")
                .withImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ50Nuo2tDAJYFDEGkFrbpTeROSk6haljdj3fYKwjLc7Pnbb7PDrw&s")
                .build();

        Menu amenu7 = new MenuBuilder().withName("Juan7")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— Buenos días. Busco trabajo.\n" +
                        "\n" +
                        "— ¿Le interesa de jardinero?\n" +
                        "\n" +
                        "— ¿Dejar dinero? ¡Si lo que busco es trabajo!")
                .withImg("https://media-cdn.tripadvisor.com/media/photo-s/11/25/cb/b3/nas-popularni-mix-6-wwwfastfoo.jpg")
                .build();

        Menu amenu8 = new MenuBuilder().withName("Juan8")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("— Abuelo, ¿por qué estás delante del ordenador con los ojos cerrados?\n" +
                        "\n" +
                        "— Es que Windows me ha dicho que cierre las pestañas.")
                .withImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8q_hEjbfe0r_UqeeMM-AzsivbqgXIptsw8WNzMAEisxFg10bI2A&s")
                .build();

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
