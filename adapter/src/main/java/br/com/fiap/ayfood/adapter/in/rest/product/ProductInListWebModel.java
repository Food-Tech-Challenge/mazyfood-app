package br.com.fiap.ayfood.adapter.in.rest.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.Valor;

public record ProductInListWebModel(
        int id, String nome, Category category, String descricao, Valor valor, String imagem) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.getProductId(), product.getNome(), product.getCategory(), product.getDescricao(), product.getValor(), product.getImagem());

    }
}
