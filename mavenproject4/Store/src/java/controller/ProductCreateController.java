package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductCreateController {

    @RequestMapping(value = "/product_create", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("product", new Product());
        System.out.println("ProductCreateController GET");
        return "product_create";
    }

    @RequestMapping(value = "/product_create", method = RequestMethod.POST)
    public String createProduct(
            @RequestParam(value="product_name", required=true) String name, 
            ModelMap model) throws ClassNotFoundException {
        System.out.println("ProductCreateController POST");
        Product.createNewProduct(name);
        return "product";
    }
}
