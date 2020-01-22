package com.football.app.controller;

import com.football.app.model.FootballTournament;
import com.football.app.repos.TeamsRepo;
import com.football.app.repos.TournamentsRepo;
import com.football.app.service.LogoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/addtour")
public class TournamentsController {

    private final TournamentsRepo tournamentsRepo;
    private final TeamsRepo teamsRepo;
    private final LogoService logoService;

    public TournamentsController(TeamsRepo teamsRepo,TournamentsRepo tournamentsRepo,LogoService logoService) {
        this.teamsRepo = teamsRepo;
        this.tournamentsRepo = tournamentsRepo;
        this.logoService = logoService;
    }

    @GetMapping
    public String kek(Model model){

        model.addAttribute("teams",teamsRepo.findAll());

        return "addtour";
    }

    @PostMapping
    public String addTournament(
            @RequestParam String tourName,
            @RequestParam("file") MultipartFile tournamentLogo,
            Model model
    ) throws IOException {

        FootballTournament tournament = new FootballTournament(tourName);

            tournament.setLogoTour(logoService.logo(tournamentLogo));

        tournamentsRepo.save(tournament);

        return "redirect:/addtour";
    }

}
