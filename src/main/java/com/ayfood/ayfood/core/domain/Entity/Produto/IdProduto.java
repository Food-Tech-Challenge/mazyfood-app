package com.ayfood.ayfood.core.domain.Entity.Produto;

import java.util.Objects;

public record IdProduto(String value) {

    public IdProduto {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdProduto não pode ser vazio");
        }
    }
}
