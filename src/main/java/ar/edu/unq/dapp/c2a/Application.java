package ar.edu.unq.dapp.c2a;

import ar.edu.unq.dapp.c2a.model.business.Business;
import ar.edu.unq.dapp.c2a.model.business.BusinessBuilder;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientBuilder;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuBuilder;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderBuilder;
import ar.edu.unq.dapp.c2a.persistence.business.BusinessDAO;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.money.Monetary;
import java.util.Calendar;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application.properties")
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private OrderDAO orderdao;

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

}