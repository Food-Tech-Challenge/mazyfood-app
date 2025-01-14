package br.com.fiap.ayfood.model.pedido;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ayfood.model.cliente.Cliente;
import lombok.Data;
import br.com.fiap.ayfood.model.produto.Produto;

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

    public IdPedido getId() {
        IdPedido idPedido = new IdPedido("2");
        return idPedido;
    }

    public StatusPedido getStatus() {
        return StatusPedido.FINALIZADO;
    }

    protected Pedido() {}
}
