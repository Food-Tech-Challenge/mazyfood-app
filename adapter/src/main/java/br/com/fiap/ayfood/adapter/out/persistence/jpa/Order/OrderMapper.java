package br.com.fiap.ayfood.adapter.out.persistence.jpa.Order;

import br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer.CustomerJpaEntity;
import br.com.fiap.ayfood.adapter.out.persistence.jpa.Product.ProductJpaEntity;
import br.com.fiap.ayfood.adapter.out.persistence.jpa.Product.ProductMapper;
import br.com.fiap.ayfood.adapter.out.persistence.jpa.Customer.CustomerMapper;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderProduct;

import java.util.List;

final class OrderMapper {
    private OrderMapper() {
    }

    static OrderJpaEntity toJpaEntity(Order order) {
        OrderJpaEntity orderJpaEntity = new OrderJpaEntity();
        CustomerJpaEntity customerJpaEntity = CustomerMapper.toJpaEntity(order.getCustomer());
        if(order.getId() != null) {
            orderJpaEntity.setId(order.getOrderId());
        }
        orderJpaEntity.setCustomer(customerJpaEntity);
        orderJpaEntity.setProducts(
                order.orderProducts().stream().map(orderProduct -> toJpaEntity(orderJpaEntity, orderProduct)).toList()
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
        Order order = new Order();
        return updateModelEntity(order, jpaEntity);
    }

    static Order updateModelEntity(Order order, OrderJpaEntity jpaEntity) {
        Customer customer = CustomerMapper.toModelEntity(jpaEntity.getCustomer());
        order.setId(new OrderId(jpaEntity.getId()));
        order.setCustomer(customer);
        order.setStatus(jpaEntity.getStatus());
        for (OrderProductJpaEntity orderProductJpaEntity : jpaEntity.getProducts()) {
            order.addProduct(ProductMapper.toModelEntity(orderProductJpaEntity.getProduct()), orderProductJpaEntity.getQuantity());
        }
        return order;

    }

    static List<Order> toModelEntities(List<OrderJpaEntity> jpaEntities) {
        return jpaEntities.stream().map(OrderMapper::toModelEntity).toList();
    }

}

