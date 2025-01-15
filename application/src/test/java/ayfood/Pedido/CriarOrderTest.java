package ayfood.Pedido;

import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CriarOrderTest {
    @Test
    public void testCriarPedido() {
        Customer customer = new Customer("18835404703", null, null);
        Order order = new Order(customer);
        assertThat(order.getCustomer()).isEqualTo(customer);
    }
}
