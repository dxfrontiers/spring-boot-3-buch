package de.springboot3.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/simple")
public class SimpleRegistrationController {

    private final UserSession session;

    public SimpleRegistrationController(UserSession session) {
        this.session = session;
    }

    @GetMapping("/register")
    public ModelAndView renderForm() {
        return formView(RegistrationForm.empty());
    }

    @PostMapping("/register")
    public ModelAndView submitForm(@ModelAttribute RegistrationForm formData) {
        if(formData.isValid()) {
            session.login(formData.name, formData.email);
            return new ModelAndView("redirect:/simple/register/success");
        }

        return formView(formData);
    }

    private ModelAndView formView(RegistrationForm formData){
        return new ModelAndView(
                "simple/register.html",
                Map.of("registrationForm", formData));
    }

    @GetMapping("/register/success")
    public ModelAndView renderSuccess() {
        return new ModelAndView("/simple/success.html",
                Map.of("name", session.getName()));
    }

    public record RegistrationForm(String name, String email) {

        public boolean isEmailValid() {
            return email != null && email.equals("test@test.com");
        }

        public boolean isNameValid() {
            return name != null && !name.isEmpty();
        }

        public boolean isValid(){
            return isEmailValid() && isNameValid();
        }

        static RegistrationForm empty() {
            return new RegistrationForm("", "");
        }

    }

}
