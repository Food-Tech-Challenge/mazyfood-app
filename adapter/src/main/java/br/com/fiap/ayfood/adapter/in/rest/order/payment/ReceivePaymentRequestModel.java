package br.com.fiap.ayfood.adapter.in.rest.order.payment;

public record ReceivePaymentRequestModel(int orderId, boolean authorized) {
}
