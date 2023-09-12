package de.springboot3.observability.tracing;

import io.micrometer.tracing.BaggageInScope;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class TracingController {

    private static final Logger logger = LoggerFactory.getLogger(TracingController.class);
    private final Tracer tracer;
    private final RestTemplate addressClient;

    public TracingController(Tracer tracer, RestTemplateBuilder restTemplateBuilder) {
        this.tracer = tracer;
        this.addressClient = restTemplateBuilder
                .rootUri("http://localhost:8080")
                .build();
    }

    @GetMapping("/customer/42")
    String getCustomer() {
        logger.info("[customer-service]: /customer/42 called!");
        logger.info("[customer-service] parentId: {}; traceId: {}; spanId: {}",
                tracer.currentTraceContext().context().parentId(),
                tracer.currentTraceContext().context().traceId(),
                tracer.currentTraceContext().context().spanId());
        try (BaggageInScope baggage = tracer.createBaggageInScope("shard", "EU")) {
            addressClient.getForObject("/address/{addressId}", String.class, Map.of("addressId", "4711"));
            logger.info("[customer-service]: received response from address-service");
            return "customer 42";
        }
    }

    @GetMapping("/address/4711")
    String getAddress(@RequestHeader Map<String, String> headers) {
        logger.info("[address-service]: /address/4711 called!");
        logger.info("[address-service]: parentId: {}; traceId: {}; spanId: {}",
                tracer.currentTraceContext().context().parentId(),
                tracer.currentTraceContext().context().traceId(),
                tracer.currentTraceContext().context().spanId());
        logger.info("[address-service]: Baggage 'shard': {}", tracer.getBaggage("geo").get());
        return "address 4711";
    }

}
