package br.com.fiap.ayfood.application.service.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.ReceiveOrderPaymentUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

public class ReceiveOrderPaymentService implements ReceiveOrderPaymentUseCase {
    private final OrderRepository orderRepository;

    public ReceiveOrderPaymentService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void receivePayment(OrderId orderId, boolean authorized) throws OrderPaymentException {
        Order order = orderRepository.findById(orderId).get();
        if (order.getStatus() != OrderStatus.INICIADO) {
            throw new OrderPaymentException("Order already paid.");
        }
        if (authorized) {
            order.setStatus(OrderStatus.RECEBIDO);
            orderRepository.save(order);
        }
    }
}
