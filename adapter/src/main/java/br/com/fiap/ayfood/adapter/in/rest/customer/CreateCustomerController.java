package br.com.fiap.ayfood.adapter.in.rest.customer;

import br.com.fiap.ayfood.adapter.in.rest.customer.dto.CreateCustomerRequest;
import br.com.fiap.ayfood.adapter.in.rest.customer.dto.CustomerResponse;
import br.com.fiap.ayfood.application.port.in.customer.CreateCustomerUseCase;
import br.com.fiap.ayfood.model.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CreateCustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;

    public CreateCustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping("/create")
    ResponseEntity<CustomerResponse> createCustomer(
            @RequestBody CreateCustomerRequest createCustomerRequest
    ) {
        Customer customer = createCustomerUseCase.createCustomer(createCustomerRequest.cpf(), createCustomerRequest.name(), createCustomerRequest.email());
        return ResponseEntity.ok(CustomerResponse.fromDomain(customer));
    }
}