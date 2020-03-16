package com.football.app.controller;

import com.football.app.service.TournamentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournaments")
public class TourListController {

    private final TournamentService tournamentService;

    public TourListController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public String tourList(Model model){

        model.addAttribute("tourList",tournamentService.tourList());

        return "tour";
    }
}
