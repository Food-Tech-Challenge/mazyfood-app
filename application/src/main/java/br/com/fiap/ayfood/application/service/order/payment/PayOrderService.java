package br.com.fiap.ayfood.application.service.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.application.port.out.PaymentGateway;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

public class PayOrderService implements PayOrderUseCase {
    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;

    public PayOrderService(OrderRepository orderRepository, PaymentGateway paymentGateway) {
        this.orderRepository = orderRepository;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public boolean processPayment(OrderId orderId) {
        Order order = orderRepository.findById(orderId).get();
        if (order.getStatus() != OrderStatus.INICIADO) {
            return false;
        }
        boolean paymentIsAuthorized = paymentGateway.authorizePayment();
        if (paymentIsAuthorized) {
            order.setStatus(OrderStatus.RECEBIDO);
        }
        orderRepository.save(order);
        return paymentIsAuthorized;
    }
}
