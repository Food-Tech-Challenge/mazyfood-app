package br.com.fiap.ayfood.adapter.in.rest.customer;

import br.com.fiap.ayfood.adapter.in.rest.customer.dto.CustomerResponse;
import br.com.fiap.ayfood.application.port.in.customer.GetCustomerUseCase;
import br.com.fiap.ayfood.model.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class GetCustomerController {

    private final GetCustomerUseCase getCustomerUseCase;

    public GetCustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @GetMapping("/")
    public ResponseEntity<CustomerResponse> getCustomerByCpf(@RequestParam(value = "cpf") String cpf) {
        Optional<Customer> customer = getCustomerUseCase.findByCpf(cpf);
        if (customer.isPresent()) {
            return ResponseEntity.ok(CustomerResponse.fromDomain(customer.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
