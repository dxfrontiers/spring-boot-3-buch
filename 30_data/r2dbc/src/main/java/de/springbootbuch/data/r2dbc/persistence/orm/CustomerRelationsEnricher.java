package de.springbootbuch.data.r2dbc.persistence.orm;

import de.springbootbuch.data.r2dbc.persistence.OrderRepository;
import de.springbootbuch.data.r2dbc.persistence.model.Customer;
import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.r2dbc.mapping.event.AfterConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomerRelationsEnricher implements AfterConvertCallback<Customer> {

    private final OrderRepository orderRepository;

    public CustomerRelationsEnricher(@Lazy OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Publisher<Customer> onAfterConvert(Customer customer, SqlIdentifier table) {
        return Mono
                .just(customer)
                .zipWith(orderRepository
                        .findByCustomerId(customer.getId())
                        .map(order -> order.setCustomer(customer))
                        .flatMap(order -> orderRepository
                                .findProductsByOrderId(order.getId())
                                .collectList()
                                .map(order::setProducts))
                        .collectList())
                .map(t -> t.getT1().setOrders(t.getT2()));
    }
}
