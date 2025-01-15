package br.com.fiap.ayfood.model.product;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {

    private ProductId id;
    private String nome;
    private Category category;
    private String descricao;
    private double preco;
    private String imagem;

    public Product(ProductId productId, String nome, Category category, String descricao, double preco, String imagem) {
        this.id = productId;
        this.nome = nome;
        this.category = category;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    protected Product() {
    }
}
