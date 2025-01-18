package br.com.fiap.ayfood;

import br.com.fiap.ayfood.application.port.in.customer.IdentifyCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.in.product.CreateProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.DeleteProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.EditProductUseCase;
import br.com.fiap.ayfood.application.port.in.product.GetProductByCategoryUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.port.out.persistence.ProductRepository;
import br.com.fiap.ayfood.application.service.customer.IdentifyCustomerService;
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

    @Bean
    CreateOrderUseCase getCartUseCase() {
        return new CreateOrderService(orderRepository);
    }

    @Autowired
    ProductRepository productRepository;

    @Bean
    CreateProductUseCase getCreateProductUseCase() {return new CreateProductService(productRepository);}

    @Bean
    EditProductUseCase getEditProductUseCase() {return new EditProductService(productRepository);}

    @Bean
    DeleteProductUseCase getDeleteProductUseCase() {return new DeleteProductService(productRepository);}

    @Bean
    GetProductByCategoryUseCase getProductByCategoryUseCase() {
        return new GetProductByCategoryService(productRepository);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Bean
    IdentifyCustomerUseCase getIdentifyCustomerUseCase() {
        return new IdentifyCustomerService(customerRepository);
    }
}
