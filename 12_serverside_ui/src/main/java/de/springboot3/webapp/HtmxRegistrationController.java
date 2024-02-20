package de.springboot3.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/htmx")
public class HtmxRegistrationController {

    private final UserSession session;

    public HtmxRegistrationController(UserSession session) {
        this.session = session;
    }

    @GetMapping("/register")
    public ModelAndView renderForm() {
        return new ModelAndView(
                "htmx/register.html",
                Map.of("registrationForm", RegistrationForm.empty()));
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute RegistrationForm formData) {
        if (formData.isValid()) {
            session.login(formData.name, formData.email);
            return "redirect:/htmx/register/success";
        }

        return "redirect:/htmx/register/validate";
    }

    @GetMapping("/register/success")
    public ModelAndView renderSuccess() {
        return new ModelAndView("htmx/success.html",
                Map.of("name", session.getName()));
    }

    @PostMapping(value = "/register/validate", headers = "HX-Request")
    public ModelAndView validate(@ModelAttribute RegistrationForm formData) {
        return new ModelAndView(
                "htmx/fragments :: form",
                Map.of("registrationForm", formData));
    }

    public record RegistrationForm(String name, String email) {

        public boolean isEmailValid() {
            return email.equals("test@test.com");
        }

        public boolean isNameValid() {
            return name != null && !"".equals(name);
        }

        public boolean isValid() {
            return isEmailValid() && isNameValid();
        }

        static RegistrationForm empty() {
            return new RegistrationForm("", "");
        }

    }

}
