package br.com.fiap.ayfood.model.product;

import java.util.Objects;

public record ProductId(String value) {

    public ProductId {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdProduto não pode ser vazio");
        }
    }
}
