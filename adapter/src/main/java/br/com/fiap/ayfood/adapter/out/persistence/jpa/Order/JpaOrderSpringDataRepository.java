package br.com.fiap.ayfood.adapter.out.persistence.jpa.Order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderSpringDataRepository extends JpaRepository<OrderJpaEntity, Integer> {
}
