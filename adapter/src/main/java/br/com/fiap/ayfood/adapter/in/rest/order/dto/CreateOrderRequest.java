package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import java.util.Optional;

public record CreateOrderRequest(Optional<Integer> customerId) {
}
