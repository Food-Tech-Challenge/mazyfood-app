package br.com.fiap.ayfood.model.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Produto {

    private IdProduto id;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(IdProduto idProduto, String nome, String descricao, float preco) {
        this.id = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    protected Produto() {
    }
}
