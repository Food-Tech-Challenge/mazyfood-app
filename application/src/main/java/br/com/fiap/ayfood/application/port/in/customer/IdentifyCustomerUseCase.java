package br.com.fiap.ayfood.application.port.in.customer;

import br.com.fiap.ayfood.model.customer.Customer;

import java.util.Optional;

public interface IdentifyCustomerUseCase {
    Optional<Customer> findByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}
