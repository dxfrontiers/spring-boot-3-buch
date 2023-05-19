package de.springboot3.extending.library.customcondition;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

@AutoConfiguration
@Conditional(CustomConditionalAutoConfiguration.EnabledCondition.class)
public class CustomConditionalAutoConfiguration {

    @Bean
    public Client customConditionalAutoConfiguredClient() {
        return new Client();
    }

    public static class EnabledCondition implements Condition {

        @Override
        public boolean matches(
                ConditionContext context,
                AnnotatedTypeMetadata metadata) {

            String enabledProperty = context
                    .getEnvironment()
                    .getProperty("client.enabled");
            return "true".equals(enabledProperty);
        }
    }
}
