package br.com.fiap.ayfood.adapter.out.persistence.inmemory;

import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.order.OrderStatus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ConditionalOnProperty(name = "persistence", havingValue = "inmemory", matchIfMissing = true)
@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private final Map<OrderId, Order> orders = new ConcurrentHashMap<>();

    private int idSequence = 1;

    public InMemoryOrderRepository() {
    }

    @Override
    public void save(Order order) {
        if (order.getId() == null) {
            order.setId(new OrderId(idSequence));
            idSequence += 1;
        }
        orders.put(order.getId(), order);
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return Optional.ofNullable(orders.get(orderId));
    }

    @Override
    public List<Order> findAll() {
        return orders.values().stream().toList();
    }
}
