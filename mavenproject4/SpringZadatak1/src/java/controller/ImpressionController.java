package controller;

import model.Impression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ImpressionController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String createForm(ModelMap model) throws ClassNotFoundException {
        model.addAttribute("impression", new Impression());
        model.addAttribute("impressions", Impression.allImpression());
        return "form";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String addImpression(@ModelAttribute("impression") Impression impression, ModelMap model) throws ClassNotFoundException {
        impression.insertImpression();
        createForm(model);
        return "form";
    }

}
