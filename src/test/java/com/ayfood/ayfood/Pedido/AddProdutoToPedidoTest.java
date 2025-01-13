package com.ayfood.ayfood.Pedido;

import com.ayfood.ayfood.core.domain.Entity.Cliente;
import com.ayfood.ayfood.core.domain.Entity.Pedido.IdPedido;
import com.ayfood.ayfood.core.domain.Entity.Pedido.Pedido;
import com.ayfood.ayfood.core.domain.Entity.Produto.IdProduto;
import com.ayfood.ayfood.core.domain.Entity.Produto.Produto;
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
        Produto produto1 = new Produto(idProduto, "burgue", "burgue fera", 10.00);

        Pedido pedido = new Pedido(idPedido, produtos, cliente);
        pedido.AdicionarProduto(produto1);

    }
}
