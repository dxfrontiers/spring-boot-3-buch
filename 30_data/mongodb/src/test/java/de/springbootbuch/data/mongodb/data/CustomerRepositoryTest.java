package de.springbootbuch.data.mongodb.data;

import de.springbootbuch.data.mongodb.data.model.Address;
import de.springbootbuch.data.mongodb.data.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class CustomerRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup() {
        prepareTestData();
    }

    @Test
    public void verifyEmbeddedMongoDb() {
        assertThat(mongoTemplate.getDb()).isNotNull();
    }

    @Test
    public void verifyFindByEmailFindsCustomer() {
        assertThat(customerRepository.findByEmail("john.doe@example.com"))
                .hasValueSatisfying(customer -> {
                    assertThat(customer.getFirstName()).isEqualTo("John");
                    assertThat(customer.getLastName()).isEqualTo("Doe");
                    assertThat(customer.getAddresses()).hasSize(2);
                });
        assertThat(customerRepository.findByEmail("unknown.user@example.com")).isEmpty();
    }

    private void prepareTestData() {
        Address address1JohnDoe = new Address()
                .setStreet("Burgerstr.")
                .setHouseNumber("42")
                .setPostalCode("43535")
                .setCity("Somewheringen");
        Address address2JohnDoe = new Address()
                .setStreet("Noodlestr.")
                .setHouseNumber("23")
                .setPostalCode("12345")
                .setCity("Elsingen");

        mongoTemplate.insert(address1JohnDoe);
        mongoTemplate.insert(address2JohnDoe);

        Customer johnDoe = new Customer()
                .setCustomerId(1L)
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setAddresses(List.of(address1JohnDoe, address2JohnDoe));
        Customer janeSmith = new Customer()
                .setCustomerId(2L)
                .setFirstName("Jane")
                .setLastName("Smith")
                .setEmail("jane.smith@example.com");

        mongoTemplate.insert(johnDoe);
        mongoTemplate.insert(janeSmith);
    }
}
