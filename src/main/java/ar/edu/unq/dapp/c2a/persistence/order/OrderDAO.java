package ar.edu.unq.dapp.c2a.persistence.order;

import ar.edu.unq.dapp.c2a.model.order.Order;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface OrderDAO extends org.springframework.data.repository.CrudRepository<Order, Serializable> {
Iterable<Order> findByClient_Id(Serializable clientId);
}
