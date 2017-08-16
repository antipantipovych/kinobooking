package com.kinobooking.secure.controller;

import com.kinobooking.secure.entity.Client;
import com.kinobooking.secure.service.ClientServiceImpl;
import com.kinobooking.secure.validator.EmailExistsException;
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

    private ClientServiceImpl service;

    @RequestMapping(method = RequestMethod.GET)
    public String showRegistrationForm( Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "registr";
    }
    @RequestMapping( method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("client")Client client,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("firstName", client.getFirstName());
        model.addAttribute("lastName", client.getLastName());
        model.addAttribute("email", client.getEmail());
        model.addAttribute("password", client.getPassword());
        model.addAttribute("confirmPass", client.getConfirmPass());

        return "login";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public  ModelAndView registerUserAccount(@ModelAttribute("client") @Valid Client account, BindingResult result, WebRequest request,
//                                     Errors errors) {
//
//        Client registered = new Client();
//        if (!result.hasErrors()) {
//            registered = createUserAccount(account, result);
//        }
//        if (registered == null) {
//            result.rejectValue("email", "message.regError");
//        }
//        if (result.hasErrors()) {
//            return new ModelAndView("registration", "client", account);
//        }
//        else {
//            return new ModelAndView("successRegister", "client", account);
//        }
//    }

    @ModelAttribute("client")
    public Client newClient(){
        return new Client();
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
