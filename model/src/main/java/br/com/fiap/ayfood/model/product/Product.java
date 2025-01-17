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
    private Valor valor;
    private String imagem;

    public Product(ProductId productId, String nome, Category category, String descricao, Valor valor, String imagem) {
        this.id = productId;
        this.nome = nome;
        this.category = category;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
    }

    public int getProductId() {
        return this.getId().value();
    }

    protected Product() {
    }
}
