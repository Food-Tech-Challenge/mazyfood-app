package br.com.fiap.ayfood.model.customer;

import java.util.Objects;

public record CustomerId(String value) {
    public CustomerId {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdPedido não pode estar vazio");
        }
    }
}
