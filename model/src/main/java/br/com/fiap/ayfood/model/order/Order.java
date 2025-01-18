package br.com.fiap.ayfood.model.order;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class Order {
    private final Map<ProductId, OrderProduct> products = new LinkedHashMap<>();
    private OrderId id;
    private Customer customer;
    private OrderStatus status;

    public Order(Customer customer) {
        this.customer = customer;
        this.status = OrderStatus.INICIADO;
    }

    public Order() {
        this.status = OrderStatus.INICIADO;
    }

    public int getOrderId() {
        return this.getId().value();
    }

    public List<OrderProduct> orderProducts() {
        return List.copyOf(products.values());
    }

    public void addProduct(Product product, int quantity) {
        products
                .computeIfAbsent(product.getId(), ignored -> new OrderProduct(product))
                .increaseQuantityBy(quantity);
    }
}
