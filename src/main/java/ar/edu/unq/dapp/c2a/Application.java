package ar.edu.unq.dapp.c2a;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.jackson.datatype.money.MoneyModule;

import javax.money.Monetary;
import java.util.Calendar;

@SpringBootApplication
public class Application {

    @Autowired
    private OrderDAO orderdao;

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public void load() {


        Business abusiness = new BusinessBuilder().build();
        Client aclient = new ClientBuilder().build();


        Menu amenu = new MenuBuilder()
                .withFullPrice(Monetary.getDefaultAmountFactory().setNumber(10).setCurrency("ARS").create())
                .withBusiness(abusiness)
                .withStartDate(Calendar.getInstance())
                .withExpirationDate(Calendar.getInstance()).build();

        Order anyOrder = new OrderBuilder().withAmount(100).withClient(aclient).withMenu(amenu).build();

        orderdao.save(
                anyOrder
        );


    }

    @Bean
    public void configureMoneyMapper() {
        objectMapper.registerModule(new MoneyModule());
    }
}
