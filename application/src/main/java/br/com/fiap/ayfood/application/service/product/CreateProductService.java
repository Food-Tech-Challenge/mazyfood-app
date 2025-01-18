package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.CreateProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;

public class CreateProductService implements CreateProductUseCase {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String name, Category category, String description, Price price, String image) {
        Product product = new Product(name, category, description, price, image);
        productRepository.save(product);
        return product;
    }
}
