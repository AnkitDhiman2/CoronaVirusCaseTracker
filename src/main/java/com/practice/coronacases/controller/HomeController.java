package com.practice.coronacases.controller;


import com.practice.coronacases.services.CoronaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaAppService coronaAppService;

    @GetMapping("/")
    public String home(Model model)
    {


        model.addAttribute("stats", coronaAppService.getStats());


        return "home";
    }
}
