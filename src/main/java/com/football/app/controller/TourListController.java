package com.football.app.controller;

import com.football.app.model.FootballTeam;
import com.football.app.model.FootballTournament;
import com.football.app.service.DateService;
import com.football.app.service.TournamentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/tournaments")
public class TourListController {

    private final TournamentService tournamentService;
    private final DateService dateService;

    public TourListController(TournamentService tournamentService, DateService dateService) {
        this.tournamentService = tournamentService;
        this.dateService = dateService;
    }

    @GetMapping
    public String tourList(Model model){
        model.addAttribute("tourList",tournamentService.tourList());
        return "tour";
    }
    @GetMapping("/edit/{tourId}")
    public String editTourForm(@PathVariable FootballTournament tourId,Model model){
        model.addAttribute("tour", tourId);
        List<FootballTeam> footballTeams = tournamentService.teamsList();
        model.addAttribute("teams",footballTeams);
        return "editTour";
    }

    @PostMapping("/edit/{tourId}")
    public String editTour(@PathVariable Long tourId,
                           @RequestParam("tourId") FootballTournament footballTournament,
                           @RequestParam String tourName,
                           @RequestParam(required = false) String startDate,
                           @RequestParam(required = false) String endDate,
                           @RequestParam String spec,
                           @RequestParam (required = false)Boolean isActive,
                           @RequestParam (required = false)List<FootballTeam> footballTeamList,
                           Model model
                           ) throws ParseException {


        footballTournament.setActive(isActive);
        footballTournament.setName(tourName);
        footballTournament.setSpec(spec);
        footballTournament.setStartData(dateService.transformDate(startDate));
        footballTournament.setEndData(dateService.transformDate(endDate));
        footballTournament.setFootballTeams(footballTeamList);

        tournamentService.save(footballTournament);

        return "redirect:/tournaments";
    }

}
