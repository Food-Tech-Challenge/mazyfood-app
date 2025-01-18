package br.com.fiap.ayfood;

import br.com.fiap.ayfood.application.port.in.customer.CreateCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.customer.GetCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.in.product.CreateProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.DeleteProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.EditProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.GetProductByCategoryUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.application.service.customer.CreateCustomerService;
import br.com.fiap.ayfood.application.service.customer.GetCustomerService;
import br.com.fiap.ayfood.application.service.order.CreateOrderService;
import br.com.fiap.ayfood.application.service.product.CreateProductService;
import br.com.fiap.ayfood.application.service.product.DeleteProductService;
import br.com.fiap.ayfood.application.service.product.EditProductService;
import br.com.fiap.ayfood.application.service.product.GetProductByCategoryService;
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

    @Bean
    CreateOrderUseCase getCartUseCase() {
        return new CreateOrderService(orderRepository, customerRepository);
    }

    @Bean
    CreateProductUseCase getCreateProductUseCase() {
        return new CreateProductService(productRepository);
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
    GetProductByCategoryUseCase getProductByCategoryUseCase() {
        return new GetProductByCategoryService(productRepository);
    }

    @Bean
    CreateCustomerUseCase getCreateCustomerUseCase() {
        return new CreateCustomerService(customerRepository);
    }

    @Bean
    GetCustomerUseCase getIdentifyCustomerUseCase() {
        return new GetCustomerService(customerRepository);
    }
}
