package br.com.fiap.ayfood.adapter.out.persistence.jpa.Order;

import br.com.fiap.ayfood.adapter.out.persistence.jpa.Product.ProductJpaEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "order_products")
public class OrderProductJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Relacionamento com Order
    @JoinColumn(name = "order_id", nullable = false)
    private OrderJpaEntity order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Relacionamento com Product
    @JoinColumn(name = "product_id", nullable = false)
    private ProductJpaEntity product;

    @Column(nullable = false)
    private int quantity;

}
