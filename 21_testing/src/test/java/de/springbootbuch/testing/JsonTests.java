package de.springbootbuch.testing;

import de.springbootbuch.testing.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class JsonTests {

    @Autowired
    private JacksonTester<User> tester;

    @Test
    public void userDeSerialization() throws Exception {
        User user = assembleUser();
        String json = """
        {
          "firstName": "Zaphod",
          "lastName": "Beeblebrox",
          "email": "zaphod.beeblebrox@superior.being"
        }
        """;

        assertThat(tester.write(user)).isEqualToJson(json);
        assertThat(tester.parseObject(json)).isEqualTo(user);
    }

    private User assembleUser() {
        return new User()
                .setFirstName("Zaphod")
                .setLastName("Beeblebrox")
                .setEmail("zaphod.beeblebrox@superior.being");
    }

}
