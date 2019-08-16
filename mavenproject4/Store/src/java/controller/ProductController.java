package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        System.out.println("ProductController");
        model.addAttribute("product", new Product());
        return "product";
    }
}
