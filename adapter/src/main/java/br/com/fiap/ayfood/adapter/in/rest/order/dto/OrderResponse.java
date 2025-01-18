package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

import java.util.Optional;

public record OrderResponse(int id, OrderStatus orderStatus, String customerName) {
    public static OrderResponse fromDomain(Order order) {
        String customerName = Optional.ofNullable(order.getCustomer())
                .map(CreateOrderCustomerWebModel::fromDomain)
                .map(CreateOrderCustomerWebModel::name)
                .orElse(null);

        return new OrderResponse(order.getOrderId(), order.getStatus(), customerName);
    }
}
