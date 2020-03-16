package com.football.app.controller;

import com.football.app.model.FootballTeam;
import com.football.app.service.DateService;
import com.football.app.service.TournamentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller

public class TournamentsController {

    private final TournamentService tournamentService;

    public TournamentsController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }


    @GetMapping("/addtour")
    public String teamList(Model model) {

        model.addAttribute("teams", tournamentService.teamsList());
        return "addtour";
    }

    @PostMapping("/addtour")
    public String addTournament(
            @RequestParam String tourName,
            @RequestParam("file") MultipartFile tournamentLogo,
            @RequestParam("startData") String startDate,
            @RequestParam("endDate") String endDate,
            @RequestParam("specification") String spec,
            @RequestParam(value = "teamsList",required = false) List<FootballTeam> teamList,
            Model model
    ) throws IOException, ParseException {

        tournamentService.creat(tourName,tournamentLogo,startDate,endDate,spec,teamList);

        return "redirect:/tournaments";
    }



}
