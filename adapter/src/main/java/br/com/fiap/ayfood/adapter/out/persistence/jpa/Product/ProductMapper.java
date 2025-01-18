package br.com.fiap.ayfood.adapter.out.persistence.jpa.Product;

import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

import java.util.List;

public class ProductMapper {
    private ProductMapper() {
    }

    static ProductJpaEntity toJpaEntity(Product product) {
        ProductJpaEntity jpaEntity = new ProductJpaEntity();

        jpaEntity.setId(product.getId().value());
        jpaEntity.setName(product.getName());
        jpaEntity.setDescription(product.getDescription());
        jpaEntity.setCategory(product.getCategory());
        jpaEntity.setPrice(product.getPrice().value());
        jpaEntity.setImage(product.getImage());

        return jpaEntity;
    }

    public static Product toModelEntity(ProductJpaEntity jpaEntity) {
        return new Product(
                new ProductId(jpaEntity.getId()),
                jpaEntity.getName(),
                jpaEntity.getCategory(),
                jpaEntity.getDescription(),
                new Price(jpaEntity.getPrice()),
                jpaEntity.getImage());
    }

    static List<Product> toModelEntities(List<ProductJpaEntity> jpaEntities) {
        return jpaEntities.stream().map(ProductMapper::toModelEntity).toList();
    }
}
