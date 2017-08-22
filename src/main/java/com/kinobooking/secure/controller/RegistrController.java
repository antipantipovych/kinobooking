package com.kinobooking.secure.controller;

import com.kinobooking.secure.dto.ClientDto;
import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.service.ClientDetailsServiceImpl;
import com.kinobooking.secure.validator.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Екатерина on 15.08.2017.
 */
@Controller
@RequestMapping("/registr")
public class RegistrController {

    @Autowired
    private ClientDetailsServiceImpl service;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
//        Client client = new Client();
//        model.addAttribute("client", client);
        return "registr";
    }

    @RequestMapping(method = RequestMethod.POST)

    public String submit(@Valid @ModelAttribute("client") ClientDto client,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "registr";
        }
        model.addAttribute("firstName", client.getFirstName());
        model.addAttribute("lastName", client.getLastName());
        model.addAttribute("email", client.getEmail());
        model.addAttribute("password", client.getPassword());
        model.addAttribute("confirmPass", client.getConfirmPass());
        System.out.println(client.toString());
        Client registered = new Client();
        if (!result.hasErrors()) {
            try {
                registered = service.createUserAccount(client, result);
            }
            catch (EmailExistsException e){
                result.rejectValue("email", "error.client", "An account already exists for this email");
               // result.reject("EmailExists");
                return "registr";
            }
        }
        if (registered == null) {
            return "registr";
        } else {
            return "redirect:/login";
        }
    }


    @ModelAttribute("client")
    public ClientDto newClient() {
        return new ClientDto();
    }
}
