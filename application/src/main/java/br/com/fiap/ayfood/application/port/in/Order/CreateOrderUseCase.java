package br.com.fiap.ayfood.application.port.in.Order;

import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;

public interface CreateOrderUseCase {
    Order createOrder(CustomerId customerId);
}
