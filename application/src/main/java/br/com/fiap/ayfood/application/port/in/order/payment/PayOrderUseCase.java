package br.com.fiap.ayfood.application.port.in.order.payment;

import br.com.fiap.ayfood.application.service.order.payment.OrderPaymentException;
import br.com.fiap.ayfood.model.order.OrderId;

public interface PayOrderUseCase {
    String processPayment(OrderId orderId, String paymentMethod) throws OrderPaymentException;
}
