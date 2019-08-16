package controller;

import model.Product;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductChangeController {

    @RequestMapping(value = "/product_change", method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "idproduct", required = true) String id, ModelMap model) throws ClassNotFoundException {
        int productId = Integer.valueOf(id);
        model.addAttribute("product_id", productId);
        model.addAttribute("product_name", Product.getNameById(productId));
        return "product_change";
    }

    @RequestMapping(value = "/product_change", method = RequestMethod.POST)
    public String createProduct(
            @RequestParam(value = "new_product_id", required = true) String id,
            @RequestParam(value = "new_product_name", required = true) String name,
            ModelMap model) throws ClassNotFoundException {
        int productId = Integer.valueOf(id);
        Product.changeProduct(new Product(productId, name));

        return "product";
    }
}
