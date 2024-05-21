package de.springboot3.testing.web;

import de.springboot3.testing.exceptions.UserNotFoundException;
import de.springboot3.testing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    public void updateEmail(@PathVariable long id, @RequestParam String email) {
        userService.update(id, user -> user.setEmail(email));
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(UserNotFoundException ex) {
        log.info("Caught UserNotFoundException: {}", ex.getMessage());

        return ex.getMessage();
    }

}
