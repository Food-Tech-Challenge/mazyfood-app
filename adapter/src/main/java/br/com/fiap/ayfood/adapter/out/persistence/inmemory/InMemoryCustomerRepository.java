package br.com.fiap.ayfood.adapter.out.persistence.inmemory;

import br.com.fiap.ayfood.application.port.out.persistence.CustomerRepository;
import br.com.fiap.ayfood.model.customer.Customer;
import br.com.fiap.ayfood.model.customer.CustomerId;
import org.springframework.stereotype.Repository;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private final Map<CustomerId, Customer> customers = new ConcurrentHashMap<>();

    public InMemoryCustomerRepository() {
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(new CustomerId(customers.size()));
        };
        customers.put(customer.getId(), customer);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        String cpfLowerCase = cpf.toLowerCase(Locale.ROOT);
        return customers.values().stream().filter(customer -> matchesCpfQuery(customer, cpfLowerCase)).findFirst();
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        String emailLowerCase = email.toLowerCase(Locale.ROOT);
        return customers.values().stream().filter(customer -> matchesEmailQuery(customer, emailLowerCase)).findFirst();
    }

    private boolean matchesCpfQuery(Customer customer, String cpfLowerCase) {
        return customer.getCpf().toLowerCase(Locale.ROOT).equals(cpfLowerCase);
    }

    private boolean matchesEmailQuery(Customer customer, String emailLowerCase) {
        return customer.getEmail().toLowerCase(Locale.ROOT).equals(emailLowerCase);
    }
}
