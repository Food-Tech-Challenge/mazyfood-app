package br.com.fiap.ayfood.model.order;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import lombok.Data;
import br.com.fiap.ayfood.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class Order {
    private OrderId id;
    private Customer customer;
    private List<OrderProduct> products;
    private OrderStatus status;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.status = OrderStatus.INICIADO;
    }

    public void addProduct(Product product, int quantity) {
        products.add(new OrderProduct(product, quantity));
    }

    public List<OrderProduct> getProducts() {
        return List.copyOf(products);
    }
}
