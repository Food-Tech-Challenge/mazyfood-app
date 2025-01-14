package com.ayfood.ayfood.core.domain.entity.pedido;
import com.ayfood.ayfood.core.domain.entity.Cliente;
import com.ayfood.ayfood.core.domain.entity.produto.Produto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Pedido {
    private IdPedido id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.INICIADO;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    protected Pedido() {}
}
