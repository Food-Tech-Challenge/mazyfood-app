package br.com.fiap.ayfood.adapter.in.rest.order;

import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderProductRequestModel;
import br.com.fiap.ayfood.adapter.in.rest.order.dto.OrderResponse;
import br.com.fiap.ayfood.application.port.in.order.AddProductToOrderUseCase;
import br.com.fiap.ayfood.application.port.in.product.ProductNotFoundException;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class AddProductToOrderController {
    private final AddProductToOrderUseCase addProductToOrderUseCase;

    public AddProductToOrderController(AddProductToOrderUseCase addProductToOrderUseCase) {
        this.addProductToOrderUseCase = addProductToOrderUseCase;
    }

    @PutMapping("/{id}/products")
    public ResponseEntity<OrderResponse> addProductToOrder(@PathVariable int id, @RequestBody OrderProductRequestModel orderProductRequestModel) {
        OrderId orderId = new OrderId(id);
        ProductId productId = new ProductId(orderProductRequestModel.productId());
        Order order;
        try {
            order = this.addProductToOrderUseCase.addProductToOrder(orderId, productId, orderProductRequestModel.quantity());
        } catch (ProductNotFoundException productNotFoundException) {
            return ResponseEntity.notFound().build();
        }
        OrderResponse orderResponse = OrderResponse.fromDomain(order);
        return ResponseEntity.ok(orderResponse);
    }
}
