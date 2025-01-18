package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.CreateProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Product;

public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
