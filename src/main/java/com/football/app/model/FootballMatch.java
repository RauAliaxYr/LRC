package com.football.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FootballMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToMany(mappedBy = "matches")
    private List<FootballTeam> teams;

    private Date date;
    private Integer teamAGoal;
    private Integer teamBGoal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FootballTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<FootballTeam> teams) {
        this.teams = teams;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTeamAGoal() {
        return teamAGoal;
    }

    public void setTeamAGoal(Integer teamAGoal) {
        this.teamAGoal = teamAGoal;
    }

    public Integer getTeamBGoal() {
        return teamBGoal;
    }

    public void setTeamBGoal(Integer teamBGoal) {
        this.teamBGoal = teamBGoal;
    }


}
