package de.springboot3.observability.metrics;


import io.micrometer.tracing.Tracer;
import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClientCustomizer restClientCustomizer(Tracer tracer) {
        return restClientBuilder -> restClientBuilder.requestInterceptor(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                request.getHeaders().add("traceparent",
                        String.format(
                                "00-%s-%s-00",
                                tracer.currentSpan().context().traceId(),
                                tracer.currentSpan().context().spanId()));
                return execution.execute(request, body);
            }
        });
    }
}
