package ar.edu.unq.dapp.c2a.persistence.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import org.springframework.stereotype.Repository;



@Repository
public interface OrderDAO extends org.springframework.data.repository.CrudRepository<Order, Long> {
    Iterable<Order> findByClient_Id(Long clientId);
}
