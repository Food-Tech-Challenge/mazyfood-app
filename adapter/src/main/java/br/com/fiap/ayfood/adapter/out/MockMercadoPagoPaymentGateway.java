package br.com.fiap.ayfood.adapter.out;

import br.com.fiap.ayfood.adapter.in.rest.order.payment.ReceivePaymentRequestModel;
import br.com.fiap.ayfood.application.port.out.PaymentGateway;
import br.com.fiap.ayfood.model.order.OrderId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@ConditionalOnProperty(name = "paymentGateway", havingValue = "mock", matchIfMissing = true)
@Component
public class MockMercadoPagoPaymentGateway implements PaymentGateway {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public boolean authorizePayment(OrderId orderId, String targetUrl) {
        ReceivePaymentRequestModel receivePaymentRequestModel = new ReceivePaymentRequestModel(orderId.value(), true);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<ReceivePaymentRequestModel> requestEntity = new HttpEntity<>(receivePaymentRequestModel, headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    targetUrl,
                    HttpMethod.POST,
                    requestEntity,
                    String.class
            );
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}