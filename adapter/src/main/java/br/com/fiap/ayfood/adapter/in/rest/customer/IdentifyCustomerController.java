package br.com.fiap.ayfood.adapter.in.rest.customer;

import br.com.fiap.ayfood.application.port.in.customer.IdentifyCustomerUseCase;
import br.com.fiap.ayfood.application.port.in.order.CreateOrderUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class IdentifyCustomerController {

    private final IdentifyCustomerUseCase identifyCustomerUseCase;

    public IdentifyCustomerController(IdentifyCustomerUseCase identifyCustomerUseCase) {
        this.identifyCustomerUseCase = identifyCustomerUseCase;
    }
}
