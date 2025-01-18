package br.com.fiap.ayfood.application.service.order;


import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;

import java.util.Objects;

public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(CustomerId customerId) {
        Objects.requireNonNull(customerId, "'customerId' must not be null");
        Customer customer = new Customer(customerId);
        Order order = new Order(customer);
        orderRepository.save(order);
        return order;
    }
}