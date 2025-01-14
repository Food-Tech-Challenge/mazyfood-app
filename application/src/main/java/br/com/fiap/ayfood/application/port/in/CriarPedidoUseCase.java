package br.com.fiap.ayfood.application.port.in;

import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.model.pedido.Pedido;

public interface CriarPedidoUseCase {
    Pedido criarPedido(Cliente cliente);
}
