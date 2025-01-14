package com.ayfood.ayfood.Pedido;

import com.ayfood.ayfood.core.domain.entity.Cliente;
import com.ayfood.ayfood.core.domain.entity.pedido.IdPedido;
import com.ayfood.ayfood.core.domain.entity.pedido.Pedido;
import com.ayfood.ayfood.core.domain.entity.produto.IdProduto;
import com.ayfood.ayfood.core.domain.entity.produto.Produto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddProdutoToPedidoTest {

    @Test
    void testAddProdutoToPedido() {
        IdPedido idPedido = new IdPedido("1");
        IdProduto idProduto = new IdProduto("1");
        List<Produto> produtos = new ArrayList<Produto>();
        Cliente cliente = new Cliente("18835404703", null, null);
        Produto produto1 = new Produto(idProduto, "burgue", "burgue fera", 10.00f);

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(produto1);
        assertThat(pedido.getProdutos()).isEqualTo(List.of(produto1));
    }
}
