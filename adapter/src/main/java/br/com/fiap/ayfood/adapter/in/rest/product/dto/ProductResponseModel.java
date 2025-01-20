package br.com.fiap.ayfood.adapter.in.rest.product.dto;

import br.com.fiap.ayfood.model.product.Product;

import java.math.BigDecimal;

public record ProductResponseModel(int id, String name, String category, String description, BigDecimal price,
                                   String image) {
    public static ProductResponseModel fromDomain(Product product) {
        return new ProductResponseModel(
                product.getProductId(),
                product.getName(),
                product.getCategoryName(),
                product.getDescription(),
                product.getPriceDecimal(),
                product.getImage()
        );
    }
}
