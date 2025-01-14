package br.com.fiap.ayfood.model.pedido;

import java.util.Objects;

public record IdPedido(String value) {
    public IdPedido {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdPedido não pode estar vazio");
        }
    }
}
