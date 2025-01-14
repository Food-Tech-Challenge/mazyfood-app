package br.com.fiap.ayfood.application.service;


import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.model.pedido.Pedido;
import br.com.fiap.ayfood.application.port.in.CriarPedidoUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.PedidoRepository;

import java.util.Objects;

public class CriarPedidoService implements CriarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public CriarPedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido criarPedido(Cliente cliente) {
        Objects.requireNonNull(cliente, "'cliente' must not be null");
        return pedidoRepository.criar(cliente);
    }
}