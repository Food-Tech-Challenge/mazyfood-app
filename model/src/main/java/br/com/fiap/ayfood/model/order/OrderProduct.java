package br.com.fiap.ayfood.model.order;

import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderProduct {
    private final Product product;
    private int quantity;

    public void increaseQuantityBy(int value) {
        this.quantity = quantity + value;
    }

    public BigDecimal getTotal() {
        return product.getPrice().multiply(quantity).value();
    }
}
