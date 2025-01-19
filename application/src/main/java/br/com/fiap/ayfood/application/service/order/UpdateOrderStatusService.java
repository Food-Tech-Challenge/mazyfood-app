package br.com.fiap.ayfood.application.service.order;

import br.com.fiap.ayfood.application.port.in.order.UpdateOrderStatusUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

import java.util.Optional;

public class UpdateOrderStatusService implements UpdateOrderStatusUseCase {

    private final OrderRepository orderRepository;

    public UpdateOrderStatusService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> updateStatus(OrderId orderId, String status) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            order.get().setStatus(OrderStatus.valueOf(status));
            orderRepository.save(order.get());
        }

        return order;
    }
}
