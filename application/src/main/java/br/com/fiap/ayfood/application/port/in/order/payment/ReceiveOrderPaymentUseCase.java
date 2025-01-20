package br.com.fiap.ayfood.application.port.in.order.payment;

import br.com.fiap.ayfood.application.service.order.payment.OrderPaymentException;
import br.com.fiap.ayfood.model.order.OrderId;

public interface ReceiveOrderPaymentUseCase {
    void receivePayment(OrderId orderId, boolean authorized) throws OrderPaymentException;
}
