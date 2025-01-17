package br.com.fiap.ayfood.application.service.customer;

import br.com.fiap.ayfood.application.port.in.customer.IdentifyCustomerUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;

import java.util.Objects;
import java.util.Optional;

public class IdentifyCustomerService implements IdentifyCustomerUseCase {

    private final CustomerRepository customerRepository;

    public IdentifyCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        Objects.requireNonNull(cpf, "'cpf' must not be null");
        return customerRepository.findByCpf(cpf);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        Objects.requireNonNull(email, "'email' must not be null");
        return customerRepository.findByEmail(email);
    }
}
