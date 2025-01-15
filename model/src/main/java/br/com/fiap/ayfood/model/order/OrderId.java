package br.com.fiap.ayfood.model.order;

import java.util.Objects;

public record OrderId(String value) {
    public OrderId {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdPedido não pode estar vazio");
        }
    }
}
