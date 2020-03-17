package com.football.app.service;

import com.football.app.model.FootballTeam;
import com.football.app.model.FootballTournament;
import com.football.app.repos.MatchRepo;
import com.football.app.repos.TeamsRepo;
import com.football.app.repos.TournamentsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class TournamentService {

    private final TournamentsRepo tournamentsRepo;
    private final TeamsRepo teamsRepo;
    private final LogoService logoService;
    private final SearchTeamService searchTeamService;
    private final MatchRepo matchRepo;
    private final DateService dateService;

    public TournamentService(TournamentsRepo tournamentsRepo, TeamsRepo teamsRepo, LogoService logoService, SearchTeamService searchTeamService, MatchRepo matchRepo, DateService dateService) {
        this.tournamentsRepo = tournamentsRepo;
        this.teamsRepo = teamsRepo;
        this.logoService = logoService;
        this.searchTeamService = searchTeamService;
        this.matchRepo = matchRepo;
        this.dateService = dateService;
    }

    public void creat(String tourName, MultipartFile tournamentLogo, String startDate, String endDate, String spec, List<FootballTeam> footballTeams) throws IOException, ParseException {

        Date dateCreation = new Date();

        Date startDateNew = dateService.transformDate(startDate);
        Date endDateNew = dateService.transformDate(endDate);

        FootballTournament tournament = new FootballTournament();
        tournament.setName(tourName);
        tournament.setStartData(startDateNew);
        tournament.setEndData(endDateNew);
        tournament.setSpec(spec);
        tournament.setLogoTour(logoService.logo(tournamentLogo));
        tournament.setFootballTeams(footballTeams);

        if(endDateNew.after(dateCreation)){
            tournament.setActive(true);
        }else {tournament.setActive(false);}

        save(tournament);
    }

    public List<FootballTeam> teamsList() {
        List<FootballTeam> footballTeamList = teamsRepo.findAll();
        return footballTeamList;
    }

    public List<FootballTournament> tourList() {
        List<FootballTournament> tournaments = tournamentsRepo.findAll();
        return tournaments;
    }
    public void save(FootballTournament footballTournament){

        tournamentsRepo.save(footballTournament);
    }

}
