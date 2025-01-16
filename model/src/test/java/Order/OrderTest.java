package Order;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderProduct;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import br.com.fiap.ayfood.model.product.Valor;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class OrderTest {

    @Test
    void addProductsToOrder() {
        Customer customer = new Customer();
        Order order = new Order(customer);

        ProductId productId = new ProductId(1);
        Product product = new Product(productId, "Hamburguer", Category.LANCHE, "lanche fera", new Valor(new BigDecimal("10")), "");
        order.addProduct(product, 1);
        OrderProduct orderProduct = new OrderProduct(product, 1);
        assertThat(order.getProducts().get(0).getClass()).isEqualTo(orderProduct.getClass());
    }

}
