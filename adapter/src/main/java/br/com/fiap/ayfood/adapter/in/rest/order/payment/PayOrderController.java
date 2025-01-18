package br.com.fiap.ayfood.adapter.in.rest.order.payment;

import br.com.fiap.ayfood.adapter.in.rest.product.dto.ProductRequestModel;
import br.com.fiap.ayfood.adapter.in.rest.product.dto.ProductResponseModel;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.product.Category;
import br.com.fiap.ayfood.model.product.Price;
import br.com.fiap.ayfood.model.product.Product;
import br.com.fiap.ayfood.model.product.ProductId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class PayOrderController {
    private final PayOrderUseCase payOrderUseCase;

    public PayOrderController(PayOrderUseCase payOrderUseCase) {
        this.payOrderUseCase = payOrderUseCase;
    }

    @PostMapping("/{id}/payment")
    public ResponseEntity<PaymentResponseModel> processPayment(@PathVariable int id) {
        OrderId orderId = new OrderId(id);
        boolean authorized = payOrderUseCase.processPayment(orderId);
        PaymentResponseModel paymentResponseModel = new PaymentResponseModel(authorized);
        return ResponseEntity.ok(paymentResponseModel);
    }
}
