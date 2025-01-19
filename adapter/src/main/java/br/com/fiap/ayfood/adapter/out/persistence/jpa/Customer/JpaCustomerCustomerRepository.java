package br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer;

import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@ConditionalOnProperty(name = "persistence", havingValue = "postgresql", matchIfMissing = true)
@Repository
public class JpaCustomerCustomerRepository implements CustomerRepository {

    private final JpaCustomerSpringDataRepository jpaCustomerSpringDataRepository;

    public JpaCustomerCustomerRepository(JpaCustomerSpringDataRepository jpaCustomerSpringDataRepository) {
        this.jpaCustomerSpringDataRepository = jpaCustomerSpringDataRepository;
    }

    @Override
    public void save(Customer customer) {
        CustomerJpaEntity customerJpaEntity = CustomerMapper.toJpaEntity(customer);
        jpaCustomerSpringDataRepository.save(customerJpaEntity);
        customer.setId(new CustomerId(customerJpaEntity.getId()));
    }

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        Optional<CustomerJpaEntity> customerJpaEntity = jpaCustomerSpringDataRepository.findById(customerId.value());
        return customerJpaEntity.map(CustomerMapper::toModelEntity);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        Optional<CustomerJpaEntity> customerJpaEntity = jpaCustomerSpringDataRepository.filterCustomerByCpf(cpf);
        return customerJpaEntity.map(CustomerMapper::toModelEntity);
    }
}
