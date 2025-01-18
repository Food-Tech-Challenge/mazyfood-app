package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

public record OrderResponse(OrderId orderId, OrderStatus orderStatus, Customer customer) {
    public static OrderResponse fromDomain(Order order) {
        return new OrderResponse(order.getId(), order.getStatus(), order.getCustomer());
    }
}
