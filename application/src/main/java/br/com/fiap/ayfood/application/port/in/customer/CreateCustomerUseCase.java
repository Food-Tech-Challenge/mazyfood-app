package br.com.fiap.ayfood.application.port.in.customer;

import br.com.fiap.ayfood.model.customer.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer(String cpf, String name, String email);
}
