package br.com.fiap.ayfood.application.port.in.product;

import br.com.fiap.ayfood.model.product.ProductId;

public interface DeleteProductUseCase {
    void deleteProduct(ProductId productId);
}
