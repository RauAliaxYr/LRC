package com.football.app.controller;

import com.football.app.repos.TournamentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    private final TournamentsRepo tournamentsRepo;

    public MainController(TournamentsRepo tournamentsRepo) {
        this.tournamentsRepo = tournamentsRepo;
    }

    @GetMapping("/main")
    public String showTable(Model model){
        model.addAttribute("table",tournamentsRepo.findByIsActive(true));

        return "main";
    }



}
