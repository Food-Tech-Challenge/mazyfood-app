package br.com.fiap.ayfood.application.port.in.Order;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.product.ProductId;
import br.com.fiap.ayfood.model.order.Order;

public interface AddProductToOrderUseCase {

    Order addProductToOrder(Customer customer, ProductId productId, int quantity)
        throws ProductNotFoundException;
}
