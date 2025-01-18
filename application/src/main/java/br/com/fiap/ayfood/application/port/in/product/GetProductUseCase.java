package br.com.fiap.ayfood.application.port.in.product;

import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

public interface GetProductUseCase {
    Product getProduct(ProductId productId);
}
