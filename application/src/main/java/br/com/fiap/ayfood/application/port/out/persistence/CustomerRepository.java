package br.com.fiap.ayfood.application.port.out.persistence;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;

import java.util.Optional;

public interface CustomerRepository {

    void save(Customer customer);

    Optional<Customer> findById(CustomerId customerId);
    Optional<Customer> findByCpf(String cpf);

}
