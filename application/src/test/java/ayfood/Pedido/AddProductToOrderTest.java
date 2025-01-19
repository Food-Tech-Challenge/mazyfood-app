package ayfood.Pedido;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderProduct;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddProductToOrderTest {
    @Test
    void testAddProductToOrder() {
        ProductId productId = new ProductId(1);
        Price price = new Price(new BigDecimal("23.99"));
        Customer customer = new Customer("18835404703", null, null);
        Product product1 = new Product(productId, "burgue", Category.LANCHE, "burgue fera", price, null);
        Order order = new Order(customer);
        order.addProduct(product1, 1);
        OrderProduct orderProduct = order.getProducts().get(productId);
        assertThat(orderProduct).isNotNull();
        assertThat(orderProduct.getProduct()).isEqualTo(product1);
        assertThat(orderProduct.getQuantity()).isEqualTo(1);
    }
}
