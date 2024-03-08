package de.springbootbuch.data.r2dbc.web;

import de.springbootbuch.data.r2dbc.exceptions.ResourceNotFoundException;
import de.springbootbuch.data.r2dbc.persistence.CustomerRepository;
import de.springbootbuch.data.r2dbc.persistence.model.Customer;
import de.springbootbuch.data.r2dbc.persistence.model.Order;
import de.springbootbuch.data.r2dbc.web.model.UpdateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping
    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{customerId}")
    public Mono<Customer> getCustomerById(@PathVariable Long customerId) {
        return customerRepository
                .findById(customerId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResourceNotFoundException("Customer not found with id: " + customerId))));
    }

    @GetMapping("/{customerId}/orders")
    public Flux<Order> getCustomerOrders(@PathVariable Long customerId) {
        return customerRepository
                .findById(customerId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResourceNotFoundException("Customer not found with id: " + customerId))))
                .flatMapIterable(Customer::getOrders);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{customerId}")
    public Mono<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody UpdateCustomerRequest updatedCustomer) {
        return customerRepository
                .findById(customerId)
                .flatMap(customer -> customerRepository.save(customer
                        .setFirstName(updatedCustomer.firstName())
                        .setLastName(updatedCustomer.lastName())
                        .setEmail(updatedCustomer.email())))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new ResourceNotFoundException("Customer not found with id: " + customerId))));
    }

    @DeleteMapping("/{customerId}")
    public Mono<Void> deleteCustomer(@PathVariable Long customerId) {
        return customerRepository.deleteById(customerId);
    }
}
