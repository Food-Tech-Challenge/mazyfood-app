package Order;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderProduct;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class OrderTest {

    @Test
    void addProductsToOrder() {
        Customer customer = new Customer();
        Order order = new Order(customer);

        ProductId productId = new ProductId(1);
        Product product = new Product(productId, "Hamburguer", Category.LANCHE, "lanche fera", new Price(new BigDecimal("10")), "");
        order.addProduct(product, 1);
        OrderProduct expectedOrderProduct = new OrderProduct(product, 1);
        OrderProduct actualOrderProduct = order.getProducts().get(productId);
        assertThat(actualOrderProduct).isNotNull();
        assertThat(actualOrderProduct.getClass()).isEqualTo(expectedOrderProduct.getClass());
    }
}
