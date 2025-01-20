package br.com.fiap.ayfood.application.service.order;

import br.com.fiap.ayfood.application.port.in.order.GetAllOrdersUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;

import java.util.List;

public class GetAllOrdersService implements GetAllOrdersUseCase {
    private final OrderRepository orderRepository;

    public GetAllOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
