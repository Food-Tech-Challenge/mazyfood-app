package br.com.fiap.ayfood.adapter.in.rest.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.application.service.order.payment.OrderPaymentException;
import br.com.fiap.ayfood.model.order.OrderId;
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
    public ResponseEntity<PaymentResponseModel> processPayment(@PathVariable int id, @RequestBody PaymentRequestModel paymentRequestModel) {
        OrderId orderId = new OrderId(id);
        String paymentStatus;
        PaymentResponseModel paymentResponseModel;
        try {
            paymentStatus = payOrderUseCase.processPayment(orderId, paymentRequestModel.paymentMethod());
        } catch (OrderPaymentException e) {
            paymentResponseModel = new PaymentResponseModel(e.getMessage());
            return ResponseEntity.badRequest().body(paymentResponseModel);
        }
        paymentResponseModel = new PaymentResponseModel(paymentStatus);
        return ResponseEntity.ok(paymentResponseModel);
    }
}
