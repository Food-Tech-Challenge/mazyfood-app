package br.com.fiap.ayfood.application.port.in.customer;

import br.com.fiap.ayfood.model.customer.Customer;

import java.util.Optional;

public interface GetCustomerUseCase {
    Optional<Customer> findByCpf(String cpf);
}
