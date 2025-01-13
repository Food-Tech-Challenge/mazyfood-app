package com.ayfood.ayfood.core.domain.Entity.Pedido;

import java.util.Objects;

public record IdPedido(String value) {
    public IdPedido {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdPedido não pode estar vazio");
        }
    }
}
