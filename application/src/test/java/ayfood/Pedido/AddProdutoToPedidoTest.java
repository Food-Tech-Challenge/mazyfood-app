package ayfood.Pedido;

import br.com.fiap.ayfood.model.cliente.Cliente;
import br.com.fiap.ayfood.model.pedido.IdPedido;
import br.com.fiap.ayfood.model.pedido.Pedido;
import br.com.fiap.ayfood.model.produto.Categoria;
import br.com.fiap.ayfood.model.produto.IdProduto;
import br.com.fiap.ayfood.model.produto.Produto;
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
        Produto produto1 = new Produto(idProduto, "burgue", Categoria.LANCHE, "burgue fera", 10.00f, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(produto1);
        assertThat(pedido.getProdutos()).isEqualTo(List.of(produto1));
    }
}
