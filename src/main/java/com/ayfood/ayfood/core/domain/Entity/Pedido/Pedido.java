package com.ayfood.ayfood.core.domain.Entity.Pedido;
import com.ayfood.ayfood.core.domain.Entity.Cliente;
import com.ayfood.ayfood.core.domain.Entity.Produto.Produto;
import java.util.List;


import lombok.experimental.Accessors;

@Accessors(chain = true)


public class Pedido {
    private final IdPedido id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(IdPedido id, List<Produto> produtos, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = StatusPedido.RECEBIDO;
    }

    public void AdicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }


}
