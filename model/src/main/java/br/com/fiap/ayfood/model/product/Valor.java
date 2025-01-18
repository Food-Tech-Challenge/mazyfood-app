package br.com.fiap.ayfood.model.product;

import java.math.BigDecimal;

public record Valor(BigDecimal valor) {

    public static Valor of(BigDecimal valor) {
        return new Valor(valor);
    }


    public Valor multiply(int multiplicand) {
        return new Valor(valor.multiply(BigDecimal.valueOf(multiplicand)));
    }
}
