package br.com.fiap.ayfood.application.port.out.persistence;


import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.model.pedido.Pedido;

import java.util.Optional;

public interface PedidoRepository {
    Pedido criar(Cliente cliente);
    Optional<Pedido> findByCliente(Cliente cliente);
}
