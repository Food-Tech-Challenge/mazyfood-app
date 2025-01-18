package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderStatus;

import java.util.List;
import java.util.Optional;

public record OrderResponse(int id, OrderStatus orderStatus, String customerName,
                            List<OrderProductInListWebModel> products) {
    public static OrderResponse fromDomain(Order order) {
        String customerName = Optional.ofNullable(order.getCustomer())
                .map(CreateOrderCustomerWebModel::fromDomain)
                .map(CreateOrderCustomerWebModel::name)
                .orElse(null);
        List<OrderProductInListWebModel> products = order.orderProducts().stream().map(
                OrderProductInListWebModel::fromDomainModel
        ).toList();
        return new OrderResponse(order.getOrderId(), order.getStatus(), customerName, products);
    }
}
