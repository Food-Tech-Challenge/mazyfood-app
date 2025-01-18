package br.com.fiap.ayfood.adapter.in.rest.order.dto;

import br.com.fiap.ayfood.model.order.OrderProduct;

import java.math.BigDecimal;

public record OrderProductInListWebModel(
        int id, String name, String category, BigDecimal price, int quantity, BigDecimal total) {

    public static OrderProductInListWebModel fromDomainModel(OrderProduct orderProduct) {
        return new OrderProductInListWebModel(
                orderProduct.getProduct().getProductId(),
                orderProduct.getProduct().getName(),
                orderProduct.getProduct().getCategoryName(),
                orderProduct.getProduct().getPriceDecimal(),
                orderProduct.getQuantity(),
                orderProduct.getTotal()
        );
    }
}
