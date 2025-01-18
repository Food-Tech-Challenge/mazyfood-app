package br.com.fiap.ayfood.adapter.out.persistence.inmemory;

import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ConditionalOnProperty(name = "persistence", havingValue = "inmemory", matchIfMissing = true)
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<ProductId, Product> products = new ConcurrentHashMap<>();

    public InMemoryProductRepository() {
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(new ProductId(products.size() + 1));
        }
        products.put(product.getId(), product);
    }

    @Override
    public void deleteById(ProductId id) {
        products.remove(id);
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.ofNullable(products.get(productId));
    }

    @Override
    public List<Product> filterProductByCategory(Category category) {
        return List.of();
    }
}
