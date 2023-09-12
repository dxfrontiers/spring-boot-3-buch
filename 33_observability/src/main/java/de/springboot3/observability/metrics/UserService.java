package de.springboot3.observability.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class UserService {

    private final Counter loginCounter;
    private final Gauge currentUsersGauge;
    private final Timer loginTimer;

    public UserService(MeterRegistry meterRegistry) {
        this.loginCounter = Counter
                .builder("logins")
                .description("Number of user logins")
                .tag("environment", getEnvironment())
                .register(meterRegistry);

        this.currentUsersGauge = Gauge
                .builder("currentUsers", this::getCurrentUsers)
                .description("Number of currently logged-in users")
                .register(meterRegistry);

        this.loginTimer = Timer
                .builder("loginTime")
                .description("Time taken for user login process")
                .maximumExpectedValue(Duration.ofSeconds(10))
                .publishPercentiles(0.75, 0.9, 0.99)
                .serviceLevelObjectives()
                .publishPercentileHistogram()
                .register(meterRegistry);
    }

    // Using @Scheduled just to auto-trigger the metric
    @Scheduled(fixedDelay = 1000)
    public void exportMetrics() {
        // send when a user has logged in
        loginCounter.increment();

        // update the current number of logged-in users
        currentUsersGauge.measure();

        // record the time it took to call the doLogin() method
        loginTimer.record(this::doLogin);
    }

    private String getEnvironment(){
        return "prod";
    }

    private int getCurrentUsers() {
        return 1;
    }

    private void doLogin() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
