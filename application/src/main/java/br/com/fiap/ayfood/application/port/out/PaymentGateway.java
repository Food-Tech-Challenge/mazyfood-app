package br.com.fiap.ayfood.application.port.out;

public interface PaymentGateway {
    boolean authorizePayment();
}
