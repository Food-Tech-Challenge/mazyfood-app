package br.com.fiap.ayfood.application.port.out.persistence;


import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;

import java.util.Optional;


public interface OrderRepository {

    void save(Order order);
    Optional<Order> findById(OrderId orderId);

}
