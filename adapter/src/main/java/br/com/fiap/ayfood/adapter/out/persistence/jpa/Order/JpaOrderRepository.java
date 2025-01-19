package br.com.fiap.ayfood.adapter.out.persistence.jpa.Order;

import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@ConditionalOnProperty(name = "persistance", havingValue = "psql", matchIfMissing = true)
@Repository
public class JpaOrderRepository implements OrderRepository {

    private final JpaOrderSpringDataRepository jpaOrderSpringDataRepository;

    public JpaOrderRepository(JpaOrderSpringDataRepository jpaOrderSpringDataRepository) {
        this.jpaOrderSpringDataRepository = jpaOrderSpringDataRepository;
    }

    @Override
    @Transactional
    public void save(Order order) {jpaOrderSpringDataRepository.save(OrderMapper.toJpaEntity(order)); }

    @Override
    @Transactional
    public Optional<Order> findById(OrderId orderId) {
        Optional<OrderJpaEntity> orderJpaEntity = jpaOrderSpringDataRepository.findById(orderId.value());
        return orderJpaEntity.map(OrderMapper::toModelEntity);
    };

}
