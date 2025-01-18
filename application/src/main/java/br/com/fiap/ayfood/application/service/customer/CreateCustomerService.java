package br.com.fiap.ayfood.application.service.customer;

import br.com.fiap.ayfood.application.port.in.customer.CreateCustomerUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;

public class CreateCustomerService implements CreateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(String cpf, String name, String email) {
        Customer customer = new Customer(cpf, name, email);
        customerRepository.save(customer);
        return customer;
    }
}
