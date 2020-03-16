package com.football.app.controller;

import com.football.app.model.FootballTeam;
import com.football.app.model.FootballTournament;
import com.football.app.repos.TeamsRepo;
import com.football.app.repos.TournamentsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

        try {
            List<FootballTeam> footballTeams1ist = tournamentsRepo.findByIsActive(true).getFootballTeams();
            if (!footballTeams1ist.isEmpty()) {
                model.addAttribute("tables", footballTeams1ist);
            } else {
                model.addAttribute("message", "no data");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return "main";
    }


}
