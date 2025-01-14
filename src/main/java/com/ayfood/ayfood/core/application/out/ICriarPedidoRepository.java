package com.ayfood.ayfood.core.application.out;

import com.ayfood.ayfood.core.domain.entity.Cliente;
import com.ayfood.ayfood.core.domain.entity.pedido.Pedido;

public interface ICriarPedidoRepository {
    Pedido criar(Cliente cliente);
}
