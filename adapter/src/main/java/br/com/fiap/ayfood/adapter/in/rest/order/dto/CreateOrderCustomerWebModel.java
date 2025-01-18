package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.customer.Customer;

public record CreateOrderCustomerWebModel(String name) {
    public static CreateOrderCustomerWebModel fromDomain(Customer customer) {
        return new CreateOrderCustomerWebModel(customer.getName());
    }
}

