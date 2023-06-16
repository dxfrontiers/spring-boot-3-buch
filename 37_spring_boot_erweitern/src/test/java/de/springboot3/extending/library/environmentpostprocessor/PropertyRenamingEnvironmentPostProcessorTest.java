package de.springboot3.extending.library.environmentpostprocessor;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class PropertyRenamingEnvironmentPostProcessorTest {

    @SpringBootConfiguration
    @EnableAutoConfiguration
    static class EmptyConfiguration {
    }

    @Nested
    @SpringBootTest(properties = {
            "old.property=foo"
    })
    class WithPropertyPresent {
        @Autowired
        private ApplicationContext context;

        @Test
        public void renamedPropertyHasSameValue() {
            assertThat(context.getEnvironment()
                    .getProperty("renamed.property"))
                    .isEqualTo("foo");
        }
    }

    @Nested
    @SpringBootTest
    class NoPropertyPresent {
        @Autowired
        private ApplicationContext context;

        @Test
        public void renamedPropertyNotPresent() {
            assertThat(context.getEnvironment()
                    .getProperty("renamed.property"))
                    .isNull();
        }
    }


}