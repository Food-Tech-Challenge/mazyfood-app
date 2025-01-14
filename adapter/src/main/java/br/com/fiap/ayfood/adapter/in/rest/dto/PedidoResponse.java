package br.com.fiap.ayfood.adapter.in.rest.dto;

import br.com.fiap.ayfood.model.pedido.IdPedido;
import br.com.fiap.ayfood.model.pedido.Pedido;
import br.com.fiap.ayfood.model.pedido.StatusPedido;

public record PedidoResponse(IdPedido idPedido, StatusPedido statusPedido) {
    public static PedidoResponse fromDomain(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), pedido.getStatus());
    }
}
