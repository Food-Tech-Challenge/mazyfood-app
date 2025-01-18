package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.EditProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Product;

public class EditProductService implements EditProductUseCase {
    private final ProductRepository productRepository;

    public EditProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product editProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
