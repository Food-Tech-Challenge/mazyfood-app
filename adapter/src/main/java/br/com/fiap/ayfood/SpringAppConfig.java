package br.com.fiap.ayfood;

import br.com.fiap.ayfood.application.port.in.Order.CreateOrderUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.OrderRepository;
import br.com.fiap.ayfood.application.service.Order.CreateOrderService;
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
}
