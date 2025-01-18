package br.com.fiap.ayfood.application.port.out.persistence;

import br.com.fiap.ayfood.model.customer.Customer;

import java.util.Optional;

public interface CustomerRepository {

    void save(Customer customer);

    Optional<Customer> findByCpf(String cpf);

}
