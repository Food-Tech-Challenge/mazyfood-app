package br.com.fiap.ayfood.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private CustomerId id;
    private String cpf;
    private String name;
    private String email;

    public Customer(String cpf, String name, String email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public Customer(CustomerId customerId) {
        this.id = customerId;
    }
}
