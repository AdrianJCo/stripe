package uk.mediaibntaymiyya.stripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@GetMapping("/")
    @ResponseBody
    String home() {
      return "Hello World!";
    }
}
