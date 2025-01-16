package br.com.fiap.ayfood.adapter.in.rest;

import br.com.fiap.ayfood.adapter.in.rest.dto.CreateOrderRequest;
import br.com.fiap.ayfood.adapter.in.rest.dto.OrderResponse;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.ayfood.adapter.out.persistence.inmemory.InMemoryOrderRepository;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.service.order.CreateOrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;

    public OrderController() {
        OrderRepository orderRepository = new InMemoryOrderRepository();
        this.createOrderUseCase = new CreateOrderService(orderRepository);
    }

    @PostMapping("/new")
    ResponseEntity<OrderResponse> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        CustomerId customerId = new CustomerId(createOrderRequest.customerId());
        Order order = createOrderUseCase.createOrder(customerId);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }
}