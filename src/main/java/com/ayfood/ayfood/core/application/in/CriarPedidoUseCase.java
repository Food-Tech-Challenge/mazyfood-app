package com.ayfood.ayfood.core.application.in;

import com.ayfood.ayfood.core.application.out.ICriarPedidoRepository;
import com.ayfood.ayfood.core.domain.entity.Cliente;
import com.ayfood.ayfood.core.domain.entity.pedido.Pedido;

public class CriarPedidoUseCase implements ICriarPedidoRepository {

    @Override
    public Pedido criar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente Obrigatorio");
        }

        return new Pedido(cliente);
    }
}
