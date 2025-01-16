package br.com.fiap.ayfood.adapter.in.rest.dto;

import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;
import lombok.Getter;

public record CreateOrderRequest(int customerId) {
}
