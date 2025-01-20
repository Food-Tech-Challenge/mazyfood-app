package br.com.fiap.ayfood.application.port.out;

import br.com.fiap.ayfood.model.order.OrderId;

public interface PaymentGateway {
    boolean authorizePayment(OrderId orderId, String targetUrl);
}
