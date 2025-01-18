package br.com.fiap.ayfood.adapter.in.rest.product;

import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;

public record ProductInListWebModel(
        int id, String nome, Category category, String descricao, Price price, String imagem) {

    public static ProductInListWebModel fromDomainModel(Product product) {
        return new ProductInListWebModel(
                product.getProductId(), product.getName(), product.getCategory(), product.getDescription(), product.getPrice(), product.getImage());

    }
}
