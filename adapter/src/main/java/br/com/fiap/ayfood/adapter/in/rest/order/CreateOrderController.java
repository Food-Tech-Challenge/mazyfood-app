package br.com.fiap.ayfood.adapter.in.rest.order;

import br.com.fiap.ayfood.adapter.in.rest.order.dto.CreateOrderRequest;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderResponse;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.model.customer.CustomerId;
import br.com.fiap.ayfood.model.order.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class CreateOrderController {
    private final CreateOrderUseCase createOrderUseCase;

    public CreateOrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping("/create")
    ResponseEntity<OrderResponse> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest
    ) {
        CustomerId customerId = new CustomerId(createOrderRequest.customerId());
        Order order = createOrderUseCase.createOrder(customerId);
        return ResponseEntity.ok(OrderResponse.fromDomain(order));
    }
}