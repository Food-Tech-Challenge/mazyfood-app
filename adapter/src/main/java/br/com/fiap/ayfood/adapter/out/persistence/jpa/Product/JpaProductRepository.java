package br.com.fiap.ayfood.adapter.out.persistence.jpa.Product;

import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@ConditionalOnProperty(name = "persistence", havingValue = "postgresql", matchIfMissing = true)
@Repository
public class JpaProductRepository implements ProductRepository {

    private final JpaProductSpringDataRepository jpaProductSpringDataRepository;

    public JpaProductRepository(JpaProductSpringDataRepository jpaProductSpringDataRepository) {
        this.jpaProductSpringDataRepository = jpaProductSpringDataRepository;
    }

    @Override
    @Transactional
    public void save(Product product) {
        ProductJpaEntity productJpaEntity = ProductMapper.toJpaEntity(product);
        jpaProductSpringDataRepository.save(productJpaEntity);
        ProductMapper.updateModelEntity(product, productJpaEntity);
    }

    @Override
    public Optional<Product> findById(ProductId id) {
        Optional<ProductJpaEntity> productJpaEntity = jpaProductSpringDataRepository.findById(id.value());
        return productJpaEntity.map(ProductMapper::toModelEntity);
    }

    @Override
    public void deleteById(ProductId id) {
        jpaProductSpringDataRepository.deleteById(id.value());
    }

    @Transactional
    @Override
    public List<Product> filterProductByCategory(Category category) {
        List<ProductJpaEntity> entities =
                jpaProductSpringDataRepository.filterProductByCategory(category);

        return ProductMapper.toModelEntities(entities);
    }
}
