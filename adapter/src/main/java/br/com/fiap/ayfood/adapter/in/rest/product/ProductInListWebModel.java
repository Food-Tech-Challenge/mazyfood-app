package br.com.fiap.ayfood.adapter.in.rest.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;

import java.math.BigDecimal;

public record ProductInListWebModel(
        int id, String name, Category category, String description, BigDecimal price, String image) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.getProductId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getPriceDecimal(),
                product.getImage()
        );
    }
}
