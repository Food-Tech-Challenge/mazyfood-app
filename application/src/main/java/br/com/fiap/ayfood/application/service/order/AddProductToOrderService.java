package br.com.fiap.ayfood.application.service.order;

import br.com.fiap.ayfood.application.port.in.order.AddProductToOrderUseCase;
import br.com.fiap.ayfood.application.port.in.product.ProductNotFoundException;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;

public class AddProductToOrderService implements AddProductToOrderUseCase {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public AddProductToOrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Order addProductToOrder(OrderId orderId, ProductId productId, int quantity) throws ProductNotFoundException {
        Order order = orderRepository.findById(orderId).orElseThrow(ProductNotFoundException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        order.addProduct(product, quantity);
        orderRepository.save(order);
        return order;
    }
}
