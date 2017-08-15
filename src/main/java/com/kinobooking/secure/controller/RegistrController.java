package com.kinobooking.secure.controller;

import com.kinobooking.secure.entity.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Екатерина on 15.08.2017.
 */
@Controller
@RequestMapping("/registr")
public class RegistrController {
    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm( Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "registr";
    }

    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView registerUserAccount (@ModelAttribute("client") @Valid Client account,
                                             BindingResult result, WebRequest request, Errors errors) {
        Client registered = new Client();
        if (!result.hasErrors()) {
            registered = createUserAccount(account, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        // rest of the implementation
    }
    private Client createUserAccount(Client account, BindingResult result) {
        Client registered = null;
        try {
            registered = service.registerNewUserAccount(account);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }
}
