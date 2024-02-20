package de.springboot3.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ModelAndView renderHello() {
        return new ModelAndView(
                "hello.html",
                Map.of("name", "Bob"));
    }

}
