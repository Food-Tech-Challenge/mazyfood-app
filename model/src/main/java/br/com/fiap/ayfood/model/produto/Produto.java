package br.com.fiap.ayfood.model.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Produto {

    private IdProduto id;
    private String nome;
    private Categoria categoria;
    private String descricao;
    private double preco;
    private String imagem;

    public Produto(IdProduto idProduto, String nome,Categoria categoria, String descricao, double preco, String imagem) {
        this.id = idProduto;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    protected Produto() {
    }
}
