package br.com.fiap.ayfood.application.port.in.order;

import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;

import java.util.List;
import java.util.Optional;

public interface GetAllOrdersUseCase {
    List<Order> getAllOrders();
}
