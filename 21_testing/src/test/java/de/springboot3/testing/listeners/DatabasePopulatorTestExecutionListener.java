package de.springboot3.testing.listeners;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

public class DatabasePopulatorTestExecutionListener implements TestExecutionListener {

    @Override
    public void beforeTestClass(TestContext testContext) {
        // setup test database
        System.out.println("Before Test Class: " + testContext.getTestClass());
    }

    @Override
    public void afterTestClass(TestContext testContext) {
        // clear test database
        System.out.println("After Test Class: " + testContext.getTestClass());
    }
}
