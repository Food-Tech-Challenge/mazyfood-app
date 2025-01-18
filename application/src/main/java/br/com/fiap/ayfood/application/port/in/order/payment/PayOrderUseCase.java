package br.com.fiap.ayfood.application.port.in.order.payment;

import br.com.fiap.ayfood.model.order.OrderId;

public interface PayOrderUseCase {
    boolean processPayment(OrderId orderId);
}
