package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("customer", new Customer());
        return "customer";
    }
}
