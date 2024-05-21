package de.springboot3.testing.web;

import de.springboot3.testing.exceptions.UserNotFoundException;
import de.springboot3.testing.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void verifyUpdateEmailWillBeDispatched() throws Exception {
        mockMvc
                .perform(put("/users/42")
                        .queryParam("email", "zaphod.beeblebrox@superior.being"))
                .andExpect(status().isOk());

        verify(userService).update(eq(42L), any());
    }

    @Test
    public void verifyControllerMapsUserNotFoundExceptionTo404() throws Exception {
        Mockito.doThrow(UserNotFoundException.class)
                .when(userService)
                .update(eq(42L), any());

        mockMvc
                .perform(put("/users/42")
                        .queryParam("email", "zaphod.beeblebrox@superior.being"))
                .andExpect(status().isNotFound());
    }

}
