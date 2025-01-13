package com.ayfood.ayfood.core.domain.Entity;

import lombok.Getter;

@Getter

public class Cliente {
    private String cpf;
    private String nome;
    private String email;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public static Cliente anonimo() {
        return new Cliente(null, null, null);
    }

    public static Cliente informarCPF(String cpf) {
        return new Cliente(cpf, null, null);
    }

    public static Cliente completo(String nome, String email) {
        return new Cliente(null, nome, email);
    }

}
