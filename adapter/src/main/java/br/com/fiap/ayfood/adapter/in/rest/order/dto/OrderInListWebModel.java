package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;

import java.util.Optional;

public record OrderInListWebModel(
        int id, String customerName, String category) {

    public static OrderInListWebModel fromDomainModel(Order order) {
        Optional<Customer> customer = Optional.ofNullable(order.getCustomer());
        return new OrderInListWebModel(
                order.getOrderId(),
                customer.map(Customer::getName).orElse(null),
                order.getStatus().name()
        );
    }
}
