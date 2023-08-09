package de.springboot3.configuration.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(properties = {
        "custom.app-name=This is a test app",
        "weather.token=this_is_a_token"
})
@ActiveProfiles("test")
@TestPropertySource("classpath:/de/springboot3/configuration/weather/test.properties")
public class WeatherServiceTest {

    @Test
    public void test(){
        // test something
    }

}
