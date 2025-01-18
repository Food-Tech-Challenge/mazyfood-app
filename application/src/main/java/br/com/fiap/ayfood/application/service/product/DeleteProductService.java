package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.DeleteProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.ProductId;

public class DeleteProductService implements DeleteProductUseCase {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void deleteProduct(ProductId productId) {
        productRepository.deleteById(productId);
    }
}
