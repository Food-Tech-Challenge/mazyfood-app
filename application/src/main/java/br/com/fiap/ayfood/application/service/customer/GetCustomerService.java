package br.com.fiap.ayfood.application.service.customer;

import br.com.fiap.ayfood.application.port.in.customer.GetCustomerUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;

import java.util.Objects;
import java.util.Optional;

public class GetCustomerService implements GetCustomerUseCase {

    private final CustomerRepository customerRepository;

    public GetCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        Objects.requireNonNull(cpf, "'cpf' must not be null");
        return customerRepository.findByCpf(cpf);
    }
}
