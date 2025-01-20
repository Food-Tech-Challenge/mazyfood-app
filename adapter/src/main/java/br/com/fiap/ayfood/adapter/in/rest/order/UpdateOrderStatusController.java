package br.com.fiap.ayfood.adapter.in.rest.order;

import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderRequestModel;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderResponse;
import br.com.fiap.ayfood.application.port.in.order.UpdateOrderStatusUseCase;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class UpdateOrderStatusController {
    private final UpdateOrderStatusUseCase updateOrderStatusUseCase;

    public UpdateOrderStatusController(UpdateOrderStatusUseCase updateOrderStatusUseCase) {
        this.updateOrderStatusUseCase = updateOrderStatusUseCase;
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable int id, @RequestBody OrderRequestModel orderRequestModel) {
        OrderId orderId = new OrderId(id);
        String status = orderRequestModel.status();
        Optional<Order> order = updateOrderStatusUseCase.updateStatus(orderId, status);
        if (order.isPresent()) {
            OrderResponse orderResponse = OrderResponse.fromDomain(order.get());
            return ResponseEntity.ok(orderResponse);
        }
        return ResponseEntity.notFound().build();

    }
}
