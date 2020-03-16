package com.football.app.service;

import com.football.app.model.FootballTeam;
import com.football.app.repos.TeamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchTeamService {

    @Autowired
    private final TeamsRepo teamsRepo;

    public SearchTeamService(TeamsRepo teamsRepo) {
        this.teamsRepo = teamsRepo;
    }

    public List<FootballTeam> searchTeams(String... teams) {

       List<FootballTeam> footballTeamsOfTheMatch = new ArrayList<>();
        List<FootballTeam> footballTeamList = teamsRepo.findAll();

        for (String teamName : teams) {
            for (int i = 0; i < footballTeamList.size(); i++) {
                if (teamName.equals(footballTeamList.get(i).getName())) {
                    footballTeamsOfTheMatch.add(footballTeamList.get(i));
                }
            }

        }
        return footballTeamsOfTheMatch;
    }
}

