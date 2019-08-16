package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerDeleteController {

    @RequestMapping(value = "/customer_delete", method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "idcustomer", required = true) String id, ModelMap model) throws ClassNotFoundException {
        int customerId = Integer.valueOf(id);
        model.addAttribute("customer_id", customerId);
        model.addAttribute("customer_name", Customer.getNameById(customerId));
        return "customer_delete";
    }

    @RequestMapping(value = "/customer_delete", method = RequestMethod.POST)
    public String deleteCustomer(
            @RequestParam(value = "customer_id", required = true) String id,
            ModelMap model) throws ClassNotFoundException {
        int customerId = Integer.valueOf(id);
        System.out.println("ppppppppppppppppppppppppppppppppppppppppppppp:"+Integer.valueOf(id));
        Customer.deleteCustomer(Integer.valueOf(id));

        return "customer";
    }
}