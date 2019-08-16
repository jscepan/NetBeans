package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerCreateController {

    @RequestMapping(value = "/customer_create", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("customer", new Customer());
        System.out.println("CustomerCreateController GET");
        return "customer_create";
    }

    @RequestMapping(value = "/customer_create", method = RequestMethod.POST)
    public String createCustomer(
            @RequestParam(value="customer_name", required=true) String name, 
            ModelMap model) throws ClassNotFoundException {
        System.out.println("CustomerCreateController POST");
        Customer.createNewCustomer(name);
        return "customer";
    }
}
