package de.springbootbuch.data.jpa.web;

import de.springbootbuch.data.jpa.exceptions.ResourceNotFoundException;
import de.springbootbuch.data.jpa.persistence.CustomerRepository;
import de.springbootbuch.data.jpa.persistence.model.Customer;
import de.springbootbuch.data.jpa.persistence.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerRepository
                .findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
    }

    @GetMapping("/{customerId}/orders")
    public List<Order> getCustomerOrders(@PathVariable Long customerId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        return customer.getOrders();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer updatedCustomer) {
        return customerRepository
                .findById(customerId)
                .map(customer -> customerRepository.save(customer
                        .setFirstName(updatedCustomer.getFirstName())
                        .setLastName(updatedCustomer.getLastName())
                        .setEmail(updatedCustomer.getEmail())))
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
