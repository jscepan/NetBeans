package controller;

import model.Customer;
import model.Sales;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {

    @RequestMapping(value = "/sales", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("sales", new Sales());
        return "sales";
    }
}
