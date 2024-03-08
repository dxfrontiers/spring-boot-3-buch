package de.springbootbuch.data.jpa.persistence;

import de.springbootbuch.data.jpa.persistence.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void verifyFindById() {
        Customer customer = new Customer()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com");

        customerRepository.save(customer);

        Optional<Customer> actual = customerRepository.findById(customer.getId());

        assertThat(actual).isNotEmpty();
    }

    @Test
    public void verifyFindByEmailLike() {
        Customer customer1 = new Customer()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com");

        Customer customer2 = new Customer()
                .setFirstName("Jane")
                .setLastName("Smith")
                .setEmail("jane.smith@gmail.com");

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        List<Customer> customers = customerRepository.findByEmailLike("%@example%");

        assertThat(customers)
                .hasSize(1)
                .satisfiesExactly(first -> {
                    assertThat(first.getEmail()).isEqualTo("john.doe@example.com");
                });
    }
}
