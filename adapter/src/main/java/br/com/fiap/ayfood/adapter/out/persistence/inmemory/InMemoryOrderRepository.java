package br.com.fiap.ayfood.adapter.out.persistence.inmemory;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;

import java.util.Map;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ConditionalOnProperty(name = "persistence", havingValue = "inmemory", matchIfMissing = true)
@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final Map<OrderId, Order> orders = new ConcurrentHashMap<>();

    public InMemoryOrderRepository() {
    }

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            order.setId(new OrderId(orders.size()));
        };
        orders.put(order.getId(), order);
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }
}
