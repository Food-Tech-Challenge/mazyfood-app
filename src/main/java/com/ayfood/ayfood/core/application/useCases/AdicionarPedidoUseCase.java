package com.ayfood.ayfood.core.application.useCases;

import com.ayfood.ayfood.core.application.repository.IAdicionarPedidoRepository;
import com.ayfood.ayfood.core.domain.Entity.Cliente;
import com.ayfood.ayfood.core.domain.Entity.Pedido.Pedido;
import com.ayfood.ayfood.core.domain.Entity.Produto.Produto;

public class AdicionarPedidoUseCase implements IAdicionarPedidoRepository {

    @Override
    public Pedido adicionar(Cliente cliente, Produto... produtos) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente Obrigatorio");
        }

        Pedido pedido = new Pedido(cliente);

    }
}
