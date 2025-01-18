package br.com.fiap.ayfood.adapter.out.persistence.inmemory;

import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ConditionalOnProperty(name = "persistence", havingValue = "inmemory", matchIfMissing = true)
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<CustomerId, Customer> customers = new ConcurrentHashMap<>();

    public InMemoryCustomerRepository() {
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(new CustomerId(customers.size() + 1));
        }
        customers.put(customer.getId(), customer);
    }

    @Override
    public Optional<Customer> findById(CustomerId customerId) {
        return Optional.ofNullable(customers.get(customerId));
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        return customers.values().stream().filter(customer -> matchesCpfQuery(customer, cpf)).findFirst();
    }

    private boolean matchesCpfQuery(Customer customer, String cpfLowerCase) {
        return customer.getCpf().equals(cpfLowerCase);
    }
}
