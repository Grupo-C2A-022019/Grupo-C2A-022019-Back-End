package ar.edu.unq.dapp.c2a;

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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yuequan.jpa.soft.delete.repository.EnableJpaSoftDeleteRepositories;
import org.zalando.jackson.datatype.money.MoneyModule;

import javax.money.Monetary;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
@EnableJpaSoftDeleteRepositories
public class Application {

    @Autowired
    private OrderDAO orderdao;
    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public void load() {


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

        orderdao.save(
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

    @Bean
    public void configureMoneyMapper() {
        objectMapper.registerModule(new MoneyModule());
    }
}
