package ar.edu.unq.dapp.c2a.webServices;

import ar.edu.unq.dapp.c2a.model.business.BusinessImp;
import ar.edu.unq.dapp.c2a.model.client.Client;
import ar.edu.unq.dapp.c2a.model.client.ClientImp;
import ar.edu.unq.dapp.c2a.model.geo.SimpleGeoLocation;
import ar.edu.unq.dapp.c2a.model.menu.Menu;
import ar.edu.unq.dapp.c2a.model.menu.MenuImp;
import ar.edu.unq.dapp.c2a.model.order.Order;
import ar.edu.unq.dapp.c2a.model.order.OrderImp;
import ar.edu.unq.dapp.c2a.model.order.delivery.DeliveryAppointmentImp;
import ar.edu.unq.dapp.c2a.persistence.client.ClientDAO;
import ar.edu.unq.dapp.c2a.persistence.menu.MenuDAO;
import ar.edu.unq.dapp.c2a.persistence.order.OrderDAO;
import ar.edu.unq.dapp.c2a.services.order.OrderService;
import ar.edu.unq.dapp.c2a.services.order.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Configuration
public class ConfigurationProperties {

    @Bean
    @Autowired
    public OrderService transferService(OrderDAO orderDao, ClientDAO clientDao, MenuDAO menuDao) {
        return new OrderServiceImp(orderDao, clientDao, menuDao);
    }

    @Bean
    public OrderDAO orderDAO() {
        //TODO: replace with actual implementation
        return new OrderDAO() {
            @Override
            public Collection<Order> getClientOrders(Serializable clientId) {
                Collection<Order> orders = new ArrayList<>();
                orders.add(new OrderImp(
                        new ClientImp(),
                        new MenuImp(
                                new BusinessImp()
                        ),
                        1,
                        new DeliveryAppointmentImp(
                                new SimpleGeoLocation(
                                        -34d,
                                        -54d
                                ),
                                Calendar.getInstance())
                ));

                return orders;
            }

            @Override
            public Order get(Serializable id) {
                Collection<Order> clientOrders = getClientOrders(1);
                Order order = (Order) clientOrders.toArray()[0];
                order.setId(id);
                return order;
            }

            @Override
            public Order save(Order entity) {
                return entity;
            }
        };
    }

    @Bean
    public ClientDAO clientDAO() {
        //TODO: replace with actual implementation
        return new ClientDAO() {
            @Override
            public Client get(Serializable id) {
                Client client = new ClientImp();
                client.setId(id);
                return client;
            }

            @Override
            public Client save(Client entity) {
                return entity;
            }
        };
    }

    @Bean
    public MenuDAO menuDAO() {
        //TODO: replace with actual implementation
        return new MenuDAO() {
            @Override
            public Menu get(Serializable id) {
                Menu menu = new MenuImp(new BusinessImp());
                menu.setId(id);
                return menu;
            }

            @Override
            public Menu save(Menu entity) {
                return entity;
            }
        };
    }
}