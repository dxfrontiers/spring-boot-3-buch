package de.springbootbuch.testing.web;

import de.springbootbuch.testing.exceptions.UserNotFoundException;
import de.springbootbuch.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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
