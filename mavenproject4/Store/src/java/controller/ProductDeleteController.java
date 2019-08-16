package controller;

import model.Product;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductDeleteController {

    @RequestMapping(value = "/product_delete", method = RequestMethod.GET)
    public String createForm(@RequestParam(value = "idproduct", required = true) String id, ModelMap model) throws ClassNotFoundException {
        int productId = Integer.valueOf(id);
        model.addAttribute("product_id", productId);
        model.addAttribute("product_name", Product.getNameById(productId));
        return "product_delete";
    }

    @RequestMapping(value = "/product_delete", method = RequestMethod.POST)
    public String deleteProduct(
            @RequestParam(value = "product_id", required = true) String id,
            ModelMap model) throws ClassNotFoundException {
        int productId = Integer.valueOf(id);
        System.out.println("ppppppppppppppppppppppppppppppppppppppppppppp:"+Integer.valueOf(id));
        Product.deleteProduct(Integer.valueOf(id));

        return "product";
    }
}
