package br.com.fiap.ayfood.adapter.in.rest.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.model.order.OrderId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
