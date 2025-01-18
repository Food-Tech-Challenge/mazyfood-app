package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.EditProductUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

public class EditProductService implements EditProductUseCase {
    private final ProductRepository productRepository;

    public EditProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product editProduct(ProductId productId, String name, Category category, String description, Price price, String image) {
        Product product = new Product(productId, name, category, description, price, image);
        productRepository.save(product);
        return product;
    }
}
