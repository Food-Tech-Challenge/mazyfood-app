package br.com.fiap.ayfood.adapter.in.rest.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.ReceiveOrderPaymentUseCase;
import br.com.fiap.ayfood.application.service.order.payment.OrderPaymentException;
import br.com.fiap.ayfood.model.order.OrderId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ReceivePaymentWebhookController {
    private final ReceiveOrderPaymentUseCase receiveOrderPaymentUseCase;

    public ReceivePaymentWebhookController(ReceiveOrderPaymentUseCase receiveOrderPaymentUseCase) {
        this.receiveOrderPaymentUseCase = receiveOrderPaymentUseCase;
    }

    @PostMapping("/payment")
    public ResponseEntity<ReceivePaymentResponseModel> processPayment(@RequestBody ReceivePaymentRequestModel receivePaymentRequestModel) {
        OrderId orderId = new OrderId(receivePaymentRequestModel.orderId());
        try {
            receiveOrderPaymentUseCase.receivePayment(orderId, receivePaymentRequestModel.authorized());
        } catch (OrderPaymentException e) {
            ReceivePaymentResponseModel receivePaymentResponseModel = new ReceivePaymentResponseModel(orderId.value(), e.getMessage());
            return ResponseEntity.badRequest().body(receivePaymentResponseModel);
        }
        return ResponseEntity.accepted().build();
    }
}
