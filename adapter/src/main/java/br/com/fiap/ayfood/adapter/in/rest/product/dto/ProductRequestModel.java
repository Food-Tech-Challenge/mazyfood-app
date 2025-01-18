package br.com.fiap.ayfood.adapter.in.rest.product.dto;

import java.math.BigDecimal;

public record ProductRequestModel(
        String name, String category, String description, BigDecimal price, String image) {
}