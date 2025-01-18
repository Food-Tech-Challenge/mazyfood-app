package br.com.fiap.ayfood.adapter.out.persistence.jpa.Product;

import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import br.com.fiap.ayfood.model.product.Valor;

import java.util.List;

public class ProductMapper {
    private ProductMapper() {
    }

    static ProductJpaEntity toJpaEntity(Product product) {
        ProductJpaEntity jpaEntity = new ProductJpaEntity();

        jpaEntity.setId(product.getId().value());
        jpaEntity.setNome(product.getNome());
        jpaEntity.setDescricao(product.getDescricao());
        jpaEntity.setCategory(product.getCategory());
        jpaEntity.setPreco(product.getValor().valor());
        jpaEntity.setImagem(product.getImagem());

        return jpaEntity;
    }

    public static Product toModelEntity(ProductJpaEntity jpaEntity) {
        return new Product(
                new ProductId(jpaEntity.getId()),
                jpaEntity.getNome(),
                jpaEntity.getCategory(),
                jpaEntity.getDescricao(),
                new Valor(jpaEntity.getPreco()),
                jpaEntity.getImagem());
    }

    static List<Product> toModelEntities(List<ProductJpaEntity> jpaEntities) {
        return jpaEntities.stream().map(ProductMapper::toModelEntity).toList();
    }
}
