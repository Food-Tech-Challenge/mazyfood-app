package ayfood.Pedido;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.ProductId;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.Valor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddProductToOrderTest {
    @Test
    void testAddProdutoToPedido() {
        OrderId orderId = new OrderId(1);
        ProductId productId = new ProductId(1);
        Valor valor = new Valor(new BigDecimal("23,99"));
        List<Product> products = new ArrayList<Product>();
        Customer customer = new Customer("18835404703", null, null);
        Product product1 = new Product(productId, "burgue", Category.LANCHE, "burgue fera", valor, null);
        Order order = new Order(customer);

        assertThat(order.getProducts()).isEqualTo(List.of(product1));
    }
}
