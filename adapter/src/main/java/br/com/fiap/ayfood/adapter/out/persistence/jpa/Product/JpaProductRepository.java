package br.com.fiap.ayfood.adapter.out.persistence.jpa.Product;

import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@ConditionalOnProperty(name = "persistence", havingValue = "mysql")
@Repository
public class JpaProductRepository implements ProductRepository {

    private final JpaProductSpringDataRepository jpaProductSpringDataRepository;

    public JpaProductRepository(JpaProductSpringDataRepository jpaProductSpringDataRepository) {
        this.jpaProductSpringDataRepository = jpaProductSpringDataRepository;
    }

    @Override
    @Transactional
    public void save(Product product) {
        jpaProductSpringDataRepository.save(ProductMapper.toJpaEntity(product));
    }


    @Override
    @Transactional
    public List<Product> filterProductByCategory(String queryString) {
        List<ProductJpaEntity> entities =
                jpaProductSpringDataRepository.filterProductByCategory("%" + queryString + "%");

        return ProductMapper.toModelEntities(entities);
    }
}
