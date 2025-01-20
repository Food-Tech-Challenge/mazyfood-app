package br.com.fiap.ayfood.adapter.in.rest.order;

import br.com.fiap.ayfood.adapter.in.rest.order.dto.CreateOrderRequest;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderInListWebModel;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderResponse;
import br.com.fiap.ayfood.adapter.in.rest.product.ProductInListWebModel;
import br.com.fiap.ayfood.adapter.in.rest.product.dto.ProductResponseModel;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.in.order.GetAllOrdersUseCase;
import br.com.fiap.ayfood.application.port.in.order.GetOrderUseCase;
import br.com.fiap.ayfood.application.port.in.order.GetOrderedOrdersUseCase;
import br.com.fiap.ayfood.application.port.in.product.CategoryNotFoundException;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final GetAllOrdersUseCase getAllOrdersUseCase;
    private final GetOrderedOrdersUseCase getOrderedOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetOrderUseCase getOrderUseCase, GetAllOrdersUseCase getAllOrdersUseCase, GetOrderedOrdersUseCase getOrderedOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
        this.getAllOrdersUseCase = getAllOrdersUseCase;
        this.getOrderedOrdersUseCase = getOrderedOrdersUseCase;
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
    public ResponseEntity<OrderResponse> getOrder(@PathVariable int id) {
        OrderId orderId = new OrderId(id);
        Order order = getOrderUseCase.getOrder(orderId).get();
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }

    @GetMapping
    public List<OrderInListWebModel> getAllOrders() {
        List<Order> orders = getAllOrdersUseCase.getAllOrders();
        return orders.stream().map(OrderInListWebModel::fromDomainModel).toList();
    }

    @GetMapping("/ordered")
    public List<OrderInListWebModel> getOrderedProducts() {
        List<Order> orders = getOrderedOrdersUseCase.getOrderedOrders();
        return orders.stream().map(OrderInListWebModel::fromDomainModel).toList();
    }
}