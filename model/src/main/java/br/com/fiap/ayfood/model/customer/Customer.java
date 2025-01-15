package br.com.fiap.ayfood.model.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private CustomerId id;
    private String cpf;
    private String nome;
    private String email;

    public Customer(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Customer(CustomerId id) {
        this.id = id;
    }

    public static Customer anonimo() {
        return new Customer(null, null, null);
    }

    public static Customer informarCPF(String cpf) {
        return new Customer(cpf, null, null);
    }

    public static Customer completo(String cpf, String nome, String email) {
        return new Customer(cpf, nome, email);
    }
}
