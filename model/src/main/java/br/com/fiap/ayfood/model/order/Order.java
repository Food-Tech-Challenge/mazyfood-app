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
    private List<Product> products;
    private OrderStatus status;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.status = OrderStatus.INICIADO;
    }

    public CustomerId getCustomerId() {
        return this.getCustomer().getId();
    }
}
