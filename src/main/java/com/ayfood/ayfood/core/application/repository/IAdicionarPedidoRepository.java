package com.ayfood.ayfood.core.application.repository;

import com.ayfood.ayfood.core.domain.Entity.Cliente;
import com.ayfood.ayfood.core.domain.Entity.Pedido.Pedido;
import com.ayfood.ayfood.core.domain.Entity.Produto.Produto;

public interface IAdicionarPedidoRepository {
    Pedido adicionar(Cliente cliente, Produto... produto);
}
