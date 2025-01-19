package br.com.fiap.ayfood.adapter.out.persistence.jpa.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaProductSpringDataRepository extends JpaRepository<ProductJpaEntity, String> {

    @Query("SELECT p FROM ProductJpaEntity p WHERE p.name like ?1 or p.description like ?1")
    List<ProductJpaEntity> filterProductByCategory(String name);
}
