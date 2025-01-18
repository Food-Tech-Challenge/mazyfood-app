package br.com.fiap.ayfood.adapter.in.rest.order;

import br.com.fiap.ayfood.adapter.in.rest.order.dto.CreateOrderRequest;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderResponse;
import br.com.fiap.ayfood.adapter.in.rest.product.dto.ProductResponseModel;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.in.order.GetOrderUseCase;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetOrderUseCase getOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
    }

    @PostMapping
    ResponseEntity<OrderResponse> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        CustomerId customerId = createOrderRequest.customerId()
                .map(CustomerId::new)
                .orElse(null);

        Order order = createOrderUseCase.createOrder(customerId);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getProduct(@PathVariable int id) {
        OrderId orderId = new OrderId(id);
        Order order = getOrderUseCase.getOrder(orderId).get();
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }
}