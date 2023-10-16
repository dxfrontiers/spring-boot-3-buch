package de.springboot3.troubleshooting;

import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * This is a last resort "catch-all" for esoteric startup errors that happen during the
 * initialization of the logging system, for example, and would otherwise just be swallowed
 * by Spring Boot. At this time, there is no ApplicationContext, yet, so we can't
 * use Spring Boot's event listener features to listen for an ExitCodeEvent, for example.
 * <p>
 * It just prints the stacktrace to STDERR. In the worst case, the error has already been
 * logged by some other component, so that it's now in the logs twice. But that is better
 * than not having them in the logs at all.
 */
public class StartupFailureLogger implements SpringApplicationRunListener {

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("Application startup failed! See below stacktrace for details.");
        exception.printStackTrace();
    }

}
