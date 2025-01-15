package ayfood.Pedido;

import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.model.pedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CriarPedidoTest {
    @Test
    public void testCriarPedido() {
        Cliente cliente = new Cliente("18835404703", null, null);
        Pedido pedido = new Pedido(cliente);
        assertThat(pedido.getCliente()).isEqualTo(cliente);
    }
}
