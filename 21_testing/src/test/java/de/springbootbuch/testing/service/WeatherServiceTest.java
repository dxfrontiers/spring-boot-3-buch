package de.springbootbuch.testing.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {
        "custom.app-name=This is a test app",
        "weather.token=this_is_a_token"
})
@ActiveProfiles("test")
public class WeatherServiceTest {

    @Test
    public void test() {
        // ...
    }

}
