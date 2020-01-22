package com.football.app.controller;

import com.football.app.model.FootballTeam;
import com.football.app.repos.TeamsRepo;
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
@RequestMapping("/add")
public class TeamController {

    private final TeamsRepo teamsRepo;
    private final LogoService logoService;

    public TeamController(TeamsRepo teamsRepo,LogoService logoService) {
        this.teamsRepo = teamsRepo;
        this.logoService = logoService;
    }

    @GetMapping
    public String kek(Model model){
        model.addAttribute("teams", teamsRepo.findAll());
        return "add";
    }

    @PostMapping
    public String addTeams(
            @RequestParam String footballTeamName,
            @RequestParam("file") MultipartFile teamlogo,
            Model model
    ) throws IOException {

        FootballTeam footballTeam = new FootballTeam(footballTeamName);

            footballTeam.setLogo(logoService.logo(teamlogo));

        teamsRepo.save(footballTeam);

        return "redirect:/add";
    }
}
