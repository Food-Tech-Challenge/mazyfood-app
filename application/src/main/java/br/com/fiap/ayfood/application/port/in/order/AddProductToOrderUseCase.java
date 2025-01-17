package br.com.fiap.ayfood.application.port.in.order;

import br.com.fiap.ayfood.application.port.in.product.ProductNotFoundException;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.ProductId;
import br.com.fiap.ayfood.model.order.Order;

public interface AddProductToOrderUseCase {

    Order addProductToOrder(OrderId orderId, ProductId productId, int quantity)
        throws ProductNotFoundException;
}
