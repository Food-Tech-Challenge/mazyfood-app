package br.com.fiap.ayfood.application.port.out.persistence;


import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);
    Optional<Order> findByCustomer(Customer customer);
}
