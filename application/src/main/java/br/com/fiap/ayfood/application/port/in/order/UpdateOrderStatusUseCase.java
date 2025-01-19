package br.com.fiap.ayfood.application.port.in.order;

import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;

import java.util.Optional;

public interface UpdateOrderStatusUseCase {
    Optional<Order> updateStatus(OrderId orderId, String status);
}
