package br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;

import java.util.List;

final class CustomerMapper {
    private CustomerMapper() {
    }

    static CustomerJpaEntity toJpaEntity(Customer customer) {
        CustomerJpaEntity jpaEntity = new CustomerJpaEntity();

        if (customer.getId() != null) {
            jpaEntity.setId(customer.getCustomerId());
        }
        jpaEntity.setCpf(customer.getCpf());
        jpaEntity.setName(customer.getName());
        jpaEntity.setEmail(customer.getEmail());
        return jpaEntity;
    }

    static Customer toModelEntity(CustomerJpaEntity jpaEntity) {
        return new Customer(
                new CustomerId(jpaEntity.getId()),
                jpaEntity.getCpf(),
                jpaEntity.getName(),
                jpaEntity.getEmail());
    }

    static List<Customer> toModelEntities(List<CustomerJpaEntity> jpaEntities) {
        return jpaEntities.stream().map(CustomerMapper::toModelEntity).toList();
    }
}