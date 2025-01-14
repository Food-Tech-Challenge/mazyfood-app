package br.com.fiap.ayfood.model.produto;

import java.util.Objects;

public record IdProduto(String value) {

    public IdProduto {
        Objects.requireNonNull(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("IdProduto não pode ser vazio");
        }
    }
}
