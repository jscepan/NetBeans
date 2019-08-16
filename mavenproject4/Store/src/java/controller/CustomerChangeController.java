package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerChangeController {
    
    @RequestMapping(value = "/customer_change", method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "idcustomer", required = true) String id, ModelMap model) throws ClassNotFoundException {
        int customerId = Integer.valueOf(id);
        model.addAttribute("customer_id", customerId);
        model.addAttribute("customer_name", Customer.getNameById(customerId));
        return "customer_change";
    }

    @RequestMapping(value = "/customer_change", method = RequestMethod.POST)
    public String createCustomer(
            @RequestParam(value = "new_customer_id", required = true) String id,
            @RequestParam(value = "new_customer_name", required = true) String name,
            ModelMap model) throws ClassNotFoundException {
        int customerId = Integer.valueOf(id);
        Customer.changeCustomer(new Customer(customerId, name));

        return "customer";
    }
}