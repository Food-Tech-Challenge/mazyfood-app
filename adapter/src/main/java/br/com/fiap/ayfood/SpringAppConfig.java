package br.com.fiap.ayfood;

import br.com.fiap.ayfood.application.port.in.CriarPedidoUseCase;
import br.com.fiap.ayfood.application.port.out.persistence.PedidoRepository;
import br.com.fiap.ayfood.application.service.CriarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAppConfig {

    @Autowired PedidoRepository pedidoRepository;

    @Bean
    CriarPedidoUseCase getCartUseCase() {
        return new CriarPedidoService(pedidoRepository);
    }
}
