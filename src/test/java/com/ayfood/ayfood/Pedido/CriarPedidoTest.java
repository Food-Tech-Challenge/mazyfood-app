package com.ayfood.ayfood.Pedido;

import com.ayfood.ayfood.core.domain.entity.Cliente;
import com.ayfood.ayfood.core.domain.entity.pedido.Pedido;
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
