package br.com.fiap.ayfood.application.service.order;

import br.com.fiap.ayfood.application.port.in.order.GetOrderedOrdersUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;

import java.util.List;

public class GetOrderedOrdersService implements GetOrderedOrdersUseCase {
    private final OrderRepository orderRepository;

    public GetOrderedOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrderedOrders() {
        return orderRepository.getOrdered();
    }
}
