package br.com.fiap.ayfood.adapter.in.rest.customer.dto;

import br.com.fiap.ayfood.model.customer.Customer;

public record CustomerResponse(int id, String name) {
    public static CustomerResponse fromDomain(Customer customer) {
        return new CustomerResponse(customer.getCustomerId(), customer.getName());
    }
}
