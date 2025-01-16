package br.com.fiap.ayfood.model.order;

import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.Valor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderProduct {
    private final Product product;
    private int quantity;

    public void increaseQuantityBy(int value) {
        this.quantity = quantity + value;
    }

    public Valor totalProduto() {
        return product.getValor().multiply(quantity);
    }
}
