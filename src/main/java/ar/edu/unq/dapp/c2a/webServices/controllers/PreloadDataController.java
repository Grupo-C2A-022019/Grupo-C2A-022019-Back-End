package ar.edu.unq.dapp.c2a.webServices.controllers;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.category.Category;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.persistence.category.CategoryDAO;
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
    private final CategoryDAO categoryDAO;
    private final ClientDAO clientDAO;
    private final BusinessDAO businessDAO;

    @Autowired
    public PreloadDataController(OrderDAO orderDAO, MenuDAO menuDAO,BusinessService businessService,CategoryDAO categoryDAO,ClientDAO clientDAO,BusinessDAO businessDAO) {
        this.orderDAO = orderDAO;
        this.menuDAO = menuDAO;
        this.categoryDAO = categoryDAO;
        this.businessService = businessService;
        this.clientDAO=clientDAO;
        this.businessDAO=businessDAO;
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

        Client aclient = new ClientBuilder().withName("Tobias")
                .withLastName("Calvento")
                .withEmail("tobiascalvento@hotmail.com")
                .withTelephone("1132823363")
                .withImage("https://www.fundeu.es/wp-content/uploads/2014/09/timelapse-Mario-Castillo.jpg")
                .build();

        clientDAO.save(aclient);

        Business abusiness = new BusinessBuilder()
                .withName("El pollo de Peron")
                .withDescription("La milanga al gobierno")
                .withEmail("elgeneral@casarosada.com.ar")
                .withOwnerId(1L)
                .withSchedule("Lun a Vie 19:00hs a 23:59Hs - 17 Oct. Cerrado")
                .withTelephone("011 - 1710 - 1945")
                .withUrlServ("http://www.argentina.gob.ar/")
                .withImg("http://www.laprensa.com.ar/multimedios/imgs/94850_620.jpg")
                .build();

        businessDAO.save(abusiness);

        Calendar now = Calendar.getInstance();


        Calendar later = Calendar.getInstance();
        later.add(Calendar.YEAR, 1);

        Category pizza = new Category("Pizza");
        categoryDAO.save(pizza);
        Category cerveza = new Category("Cerveza");
        categoryDAO.save(cerveza);
        Category hamburguesa = new Category("Hamburguesa");
        categoryDAO.save(hamburguesa);
        Category sushi = new Category("Sushi");
        categoryDAO.save(sushi);
        Category empanadas = new Category("Empanadas");
        categoryDAO.save(empanadas);
        Category green = new Category("Green");
        categoryDAO.save(green);
        Category vegano = new Category("Vegano");
        categoryDAO.save(vegano);


        List<Category> cat3 = new ArrayList<Category>();
        cat3.add(pizza);
        cat3.add(cerveza);
        cat3.add(hamburguesa);

        List<Category> cat2 = new ArrayList<Category>();
        cat2.add(sushi);
        cat2.add(empanadas);

        Menu amenu1 = new MenuBuilder().withName("Juan1")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withImg("https://upload.wikimedia.org/wikipedia/commons/2/2e/Fast_food_meal.jpg")
                .withDescription("A nisman lo mato la policia federal Argentina")
                .withCategories(cat2)
                .build();

        Menu amenu2 = new MenuBuilder().withName("Juan2")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withDescription("Soy una descripcion estoy re loco")
                .withCategories(cat2)
                .withImg("https://static.independent.co.uk/s3fs-public/thumbnails/image/2016/12/29/16/junk-food-istock-zeljkosantrac.jpg?w968h681")
                .build();

        Menu amenu3 = new MenuBuilder().withName("Juan3")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withCategories(cat2)
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
                .withCategories(cat2)
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
                .withCategories(cat3)
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
                .withCategories(cat3)
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
                .withCategories(cat3)
                .withDescription("— Buenos días. Busco trabajo.\n" +
                        "\n" +
                        "— ¿Le interesa de jardinero?\n" +
                        "\n" +
                        "— ¿Dejar dinero? ¡Si lo que busco es trabajo!")
                .withImg("https://content3.jdmagicbox.com/comp/rajkot/b2/0281PX281.X281.120907211638.E7B2/catalogue/om-ice-cream-and-fast-food-80-feet-road-rajkot-restaurants-43susdx.jpg")
                .build();

        Menu amenu8 = new MenuBuilder().withName("Juan8")
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(now)
                .withExpirationDate(later)
                .withCategories(cat3)
                .withDescription("— Abuelo, ¿por qué estás delante del ordenador con los ojos cerrados?\n" +
                        "\n" +
                        "— Es que Windows me ha dicho que cierre las pestañas.")
                .withImg("https://thehighdefinitionwallpapers.com/blog/image/data/730/500/Delicious-and-testy-pizza-fast-food-HD.jpg")
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
