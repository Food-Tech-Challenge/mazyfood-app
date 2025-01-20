package br.com.fiap.ayfood.application.service.order.payment;

import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.application.port.out.PaymentGateway;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.model.order.Order;
import br.com.fiap.ayfood.model.order.OrderId;
import br.com.fiap.ayfood.model.order.OrderStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class PayOrderService implements PayOrderUseCase {
    private final OrderRepository orderRepository;
    private final PaymentGateway paymentGateway;

    public PayOrderService(OrderRepository orderRepository, PaymentGateway paymentGateway) {
        this.orderRepository = orderRepository;
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String processPayment(OrderId orderId, String paymentMethod) throws OrderPaymentException {
        Order order = orderRepository.findById(orderId).get();
        if (order.getStatus() != OrderStatus.INICIADO) {
            throw new OrderPaymentException("Order cannot be paid");
        }
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) {
            throw new IllegalStateException("Request is not available in the current context");
        }
        String targetUrl = getBaseUrl(request) + "/orders/payment";
        paymentGateway.authorizePayment(orderId, targetUrl);
        return "Processing order payment";
    }

    private HttpServletRequest getCurrentHttpRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            return (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        }
        return null;
    }

    private String getBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        return scheme + "://" + serverName + ":" + serverPort;
    }
}
