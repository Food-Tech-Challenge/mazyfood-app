package br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCustomerSpringDataRepository extends JpaRepository<CustomerJpaEntity, Integer> {

    @Query("SELECT c FROM CustomerJpaEntity c WHERE c.cpf = ?1")
    Optional<CustomerJpaEntity> filterCustomerByCpf(String cpf);
}
