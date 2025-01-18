package br.com.fiap.ayfood.adapter.out.persistence.jpa.Order;

import br.com.fiap.ayfood.adapter.out.persistence.jpa.Product.ProductJpaEntity;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderProduct;
import br.com.fiap.ayfood.adapter.out.persistence.jpa.Product.ProductMapper;


import java.util.List;

final class OrderMapper {
    private OrderMapper() {}

    static OrderJpaEntity toJpaEntity(Order order) {
        OrderJpaEntity orderJpaEntity = new OrderJpaEntity();
        orderJpaEntity.setProducts(
                order.getProducts().stream().map(orderProduct -> toJpaEntity(orderJpaEntity, orderProduct)).toList()
        );
        orderJpaEntity.setStatus(order.getStatus());
        return orderJpaEntity;
    }

    static OrderProductJpaEntity toJpaEntity(OrderJpaEntity orderJpaEntity, OrderProduct orderProduct) {
        ProductJpaEntity productJpaEntity = new ProductJpaEntity();
        productJpaEntity.setId(orderProduct.getProduct().getProductId());
        OrderProductJpaEntity orderProductJpaEntity = new OrderProductJpaEntity();
        orderProductJpaEntity.setOrder(orderJpaEntity);
        orderProductJpaEntity.setProduct(productJpaEntity);
        orderProductJpaEntity.setQuantity(orderProduct.getQuantity());
        return orderProductJpaEntity;
    }

    static Order toModelEntity(OrderJpaEntity jpaEntity) {
        Customer customer = new Customer(jpaEntity.getCustomer().getCpf(), jpaEntity.getCustomer().getName(), jpaEntity.getCustomer().getEmail());
        Order order = new Order(customer);

        for (OrderProductJpaEntity orderProductJpaEntity : jpaEntity.getProducts()) {
            order.addProduct(ProductMapper.toModelEntity(orderProductJpaEntity.getProduct()), orderProductJpaEntity.getQuantity());

        }
        return order;
    }

}

