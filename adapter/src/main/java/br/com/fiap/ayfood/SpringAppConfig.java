package br.com.fiap.ayfood;

import br.com.fiap.ayfood.application.port.in.customer.CreateCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.customer.GetCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.order.*;
import br.com.fiap.ayfood.application.port.in.order.payment.PayOrderUseCase;
import br.com.fiap.ayfood.application.port.in.order.payment.ReceiveOrderPaymentUseCase;
import br.com.fiap.ayfood.application.port.in.product.*;
import br.com.fiap.ayfood.application.port.out.PaymentGateway;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.application.service.customer.CreateCustomerService;
import br.com.fiap.ayfood.application.service.customer.GetCustomerService;
import br.com.fiap.ayfood.application.service.order.*;
import br.com.fiap.ayfood.application.service.order.payment.PayOrderService;
import br.com.fiap.ayfood.application.service.order.payment.ReceiveOrderPaymentService;
import br.com.fiap.ayfood.application.service.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PaymentGateway paymentGateway;

    @Bean
    CreateOrderUseCase createOrderUseCase() {
        return new CreateOrderService(orderRepository, customerRepository);
    }

    @Bean
    GetOrderUseCase getOrderUseCase() {
        return new GetOrderService(orderRepository);
    }

    @Bean
    CreateProductUseCase getCreateProductUseCase() {
        return new CreateProductService(productRepository);
    }

    @Bean
    GetProductUseCase getProductUseCase() {
        return new GetProductService(productRepository);
    }

    @Bean
    EditProductUseCase getEditProductUseCase() {
        return new EditProductService(productRepository);
    }

    @Bean
    DeleteProductUseCase getDeleteProductUseCase() {
        return new DeleteProductService(productRepository);
    }

    @Bean
    AddProductToOrderUseCase addProductToOrderUseCase() {
        return new AddProductToOrderService(orderRepository, productRepository);
    }

    @Bean
    GetAllOrdersUseCase getAllOrdersUseCase() {
        return new GetAllOrdersService(orderRepository);
    }

    @Bean
    GetOrderedOrdersUseCase getOrderedOrdersUseCase() {
        return new GetOrderedOrdersService(orderRepository);
    }

    @Bean
    GetProductByCategoryUseCase getProductByCategoryUseCase() {
        return new GetProductByCategoryService(productRepository);
    }

    @Bean
    CreateCustomerUseCase getCreateCustomerUseCase() {
        return new CreateCustomerService(customerRepository);
    }

    @Bean
    GetCustomerUseCase getGetCustomerUseCase() {
        return new GetCustomerService(customerRepository);
    }

    @Bean
    PayOrderUseCase payOrderUseCase() {
        return new PayOrderService(orderRepository, paymentGateway);
    }

    @Bean
    ReceiveOrderPaymentUseCase receiveOrderPaymentUseCase() {
        return new ReceiveOrderPaymentService(orderRepository);
    }

    @Bean
    UpdateOrderStatusUseCase updateOrderStatusUseCase() {
        return new UpdateOrderStatusService(orderRepository);
    }
}
