package br.com.fiap.ayfood.application.port.out.persistence;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;


import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    Optional<Product> findById(ProductId id);

    List<Product> filterProductByCategory(Category category);
}
