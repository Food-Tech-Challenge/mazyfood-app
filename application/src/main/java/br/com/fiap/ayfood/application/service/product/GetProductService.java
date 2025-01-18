package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.GetProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

public class GetProductService implements GetProductUseCase {
    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(ProductId productId) {
        Product product = productRepository.findById(productId).get();
        return product;
    }
}
