package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping(value = "/greeting", method
            = RequestMethod.GET)
    public String printHello(@RequestParam(value = "name", required = false, defaultValue = "User") String name, ModelMap model) {
        model.addAttribute("message", name + ", Hello from Spring MVC Framework!");
        return "greeting";
    }
}
