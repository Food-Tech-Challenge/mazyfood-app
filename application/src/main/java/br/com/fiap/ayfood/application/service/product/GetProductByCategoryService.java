package br.com.fiap.ayfood.application.service.product;

import br.com.fiap.ayfood.application.port.in.product.GetProductByCategoryUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;

import java.util.List;
import java.util.Objects;

public class GetProductByCategoryService implements GetProductByCategoryUseCase {

    private final ProductRepository productRepository;

    public GetProductByCategoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> filterProductByCategory(Category category) {
        Objects.requireNonNull(category, "'category' must not be null");
        return productRepository.filterProductByCategory(category);

    }
}
