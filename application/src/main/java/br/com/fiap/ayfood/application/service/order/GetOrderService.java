package br.com.fiap.ayfood.application.service.order;

import br.com.fiap.ayfood.application.port.in.order.GetOrderUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;

import java.util.Optional;

public class GetOrderService implements GetOrderUseCase {
    private final OrderRepository orderRepository;

    public GetOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> getOrder(OrderId orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        return order;
    }
}
