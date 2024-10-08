package de.springboot3.testing.service;

import de.springboot3.testing.listeners.DatabasePopulatorTestExecutionListener;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

@SpringBootTest
@TestExecutionListeners(
        listeners = DatabasePopulatorTestExecutionListener.class,
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS
)
public class UserServiceWithListenerTest {

    @Test
    public void test() {
        // ...
    }

}
