package br.com.fiap.ayfood.application.port.in.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;

public interface CreateProductUseCase {
    Product createProduct(String name, Category category, String description, Price price, String image);
}
