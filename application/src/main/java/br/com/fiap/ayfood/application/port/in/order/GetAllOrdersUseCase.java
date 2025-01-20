package br.com.fiap.ayfood.application.port.in.order;

import br.com.fiap.ayfood.model.order.Order;

import java.util.List;

public interface GetAllOrdersUseCase {
    List<Order> getAllOrders();
}
