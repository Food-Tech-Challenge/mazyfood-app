package br.com.fiap.ayfood.model.order;

import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderProduct {
    private final Product product;
    private int quantity;

    public void increaseQuantityBy(int value) {
        this.quantity = quantity + value;
    }

    public Price total() {
        return product.getPrice().multiply(quantity);
    }
}
