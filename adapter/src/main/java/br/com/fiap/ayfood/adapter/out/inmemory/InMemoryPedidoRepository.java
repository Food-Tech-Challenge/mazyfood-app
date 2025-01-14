package br.com.fiap.ayfood.adapter.out.inmemory;

import br.com.fiap.ayfood.model.cliente.Cliente;
import org.springframework.stereotype.Repository;
import br.com.fiap.ayfood.model.pedido.IdPedido;
import br.com.fiap.ayfood.model.pedido.Pedido;
import br.com.fiap.ayfood.application.port.out.persistence.PedidoRepository;

import java.util.Map;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryPedidoRepository implements PedidoRepository {

    private final Map<IdPedido, Pedido> pedidos = new ConcurrentHashMap<>();

    public InMemoryPedidoRepository() {
    }

    @Override
    public Pedido criar(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        pedidos.put(pedido.getId(), pedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> findByCliente(Cliente cliente) {
        Map.Entry<IdPedido,Pedido> entry = pedidos.entrySet().iterator().next();
        return Optional.ofNullable(entry.getValue());
    }
}
