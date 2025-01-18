package br.com.fiap.ayfood.application.port.in.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

public interface EditProductUseCase {
    Product editProduct(ProductId productId, String name, Category category, String description, Price price, String image);
}
