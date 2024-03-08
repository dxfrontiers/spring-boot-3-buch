package de.springbootbuch.data.flyway.persistence;

import de.springbootbuch.data.flyway.persistence.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("flyway")
@AutoConfigureTestEntityManager
public class FlywayIntegrationTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void verifyCustomerCanBePersisted() {
        testEntityManager.persist(new Customer()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setOrders(List.of())
        );
    }

}
