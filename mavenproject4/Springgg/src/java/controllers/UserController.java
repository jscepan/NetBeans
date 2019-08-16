package controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.User;

@Controller
public class UserController {

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newForm(Model model) {
        model.addAttribute("user", new User());

        return "new_user";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String sum(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model) {
        System.out.println("result:"+result.toString());
        System.out.println("user: "+user.toString());
        if (result.hasErrors()) {
            return "new_user";
        }

        model.addAttribute("first_name", user.getFirst_name());
        model.addAttribute("last_name", user.getLast_name());
        model.addAttribute("date_of_birth", user.getDate_of_birth());
        model.addAttribute("pid", user.getPid());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("country", user.getCountry());
        model.addAttribute("city", user.getCity());
        model.addAttribute("postal", user.getPostal());

        return "confirmation";

    }

}
