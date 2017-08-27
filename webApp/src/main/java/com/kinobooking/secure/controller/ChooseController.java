package com.kinobooking.secure.controller;

import com.kinobooking.secure.dto.SeansDto;
import com.kinobooking.secure.service.SeansDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Екатерина on 24.08.2017.
 */
@Controller
@RequestMapping("/choose")
public class ChooseController {
    @Autowired
    private SeansDetailsService seansDetailsService;

    @RequestMapping(method = RequestMethod.GET)
    public String showChooseForm(Model model){
        return "choose";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("seans") SeansDto seans, BindingResult result, ModelMap model){
        model.addAttribute("filmName", seans.getFilmName());
        model.addAttribute("cinemaName", seans.getCinemaName());
        model.addAttribute("seansDate", seans.getSeansDate());
        return "choose";
    }

    @ModelAttribute(value="seans")
    public SeansDto newSeans() {
        return new SeansDto();
    }

    @ModelAttribute(value="listOfFilmNames")
    public List<String> initFilmNameList(){
        return seansDetailsService.loadFilmNames();

    }

    @ModelAttribute(value="listOfCinemaNames")
    public List<String> initCinemaNameList(){
        return seansDetailsService.loadCinemaNames();

    }
}
