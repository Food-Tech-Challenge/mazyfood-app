package br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;

import java.util.List;

public final class CustomerMapper {
    private CustomerMapper() {
    }

    public static CustomerJpaEntity toJpaEntity(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerJpaEntity jpaEntity = new CustomerJpaEntity();

        if (customer.getId() != null) {
            jpaEntity.setId(customer.getCustomerId());
        }
        jpaEntity.setCpf(customer.getCpf());
        jpaEntity.setName(customer.getName());
        jpaEntity.setEmail(customer.getEmail());
        return jpaEntity;
    }

    public static Customer toModelEntity(CustomerJpaEntity jpaEntity) {
        Customer customer = new Customer();
        return updateModelEntity(jpaEntity, customer);
    }

    static Customer updateModelEntity(CustomerJpaEntity jpaEntity, Customer customer) {
        if (jpaEntity == null) {
            return null;
        }

        customer.setId(new CustomerId(jpaEntity.getId()));
        customer.setCpf(jpaEntity.getCpf());
        customer.setName(jpaEntity.getName());
        customer.setEmail(jpaEntity.getEmail());
        return customer;
    }


    static List<Customer> toModelEntities(List<CustomerJpaEntity> jpaEntities) {
        return jpaEntities.stream().map(CustomerMapper::toModelEntity).toList();
    }
}