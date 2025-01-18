package br.com.fiap.ayfood.adapter.out;

import br.com.fiap.ayfood.application.port.out.PaymentGateway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "paymentGateway", havingValue = "mock", matchIfMissing = true)
@Component
public class MockMercadoPagoPaymentGateway implements PaymentGateway {
    public MockMercadoPagoPaymentGateway() {
    }

    @Override
    public boolean authorizePayment() {
        return true;
    }
}
