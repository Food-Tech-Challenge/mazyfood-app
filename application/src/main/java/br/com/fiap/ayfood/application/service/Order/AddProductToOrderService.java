package br.com.fiap.ayfood.application.service.Order;

import br.com.fiap.ayfood.application.port.in.Order.AddProductToOrderUseCase;
import br.com.fiap.ayfood.application.port.in.Order.ProductNotFoundException;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
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
    public Order addProductToOrder(Customer customer, ProductId productId, int quantity)
        throws ProductNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        Order order = orderRepository.findByCustomer(customer).orElseGet(() -> new Order(customer));
        order.addProduct(product, quantity);
        orderRepository.save(order);
        return order;
    }
}
