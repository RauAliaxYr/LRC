package com.football.app.controller;

import com.football.app.model.FootballTournament;
import com.football.app.repos.TeamsRepo;
import com.football.app.repos.TournamentsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final TournamentsRepo tournamentsRepo;
    private final TeamsRepo teamsRepo;

    public MainController(TournamentsRepo tournamentsRepo, TeamsRepo teamsRepo) {
        this.teamsRepo = teamsRepo;
        this.tournamentsRepo = tournamentsRepo;
    }

    @GetMapping("/main")
    public String showTable(Model model) {

        FootballTournament footballTeams = tournamentsRepo.findByIsActive(true);

        model.addAttribute("tables", footballTeams);

        return "main";
    }


}
