package br.com.fiap.ayfood.application.service.order;


import br.com.fiap.ayfood.application.port.in.customer.CustomerNotFoundException;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;

import java.util.Objects;

public class CreateOrderService implements CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public CreateOrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Order createOrder(CustomerId customerId) {
        Order order;
        if (Objects.isNull(customerId)) {
            order = new Order();
        } else {
            Customer customer = customerRepository.findById(customerId).get();
            order = new Order(customer);
        }
        orderRepository.save(order);
        return order;
    }
}