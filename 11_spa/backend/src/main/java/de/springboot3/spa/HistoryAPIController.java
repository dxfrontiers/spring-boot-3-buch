package de.springboot3.spa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HistoryAPIController {

  @RequestMapping(value = "/{path:[^.]*}")
  public String redirect() {
    return "forward:/";
  }

}
