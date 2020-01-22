package com.football.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class FootballTournament {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date startData;
    private Date endData;
    private Boolean isActive;
    private String logoTour;

    @ManyToMany(mappedBy = "tournamentList")
    private List<FootballTeam> footballTeams;

    public FootballTournament() {
    }

    public FootballTournament(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartData() {
        return startData;
    }

    public void setStartData(Date startData) {
        this.startData = startData;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<FootballTeam> getFootballTeams() {
        return footballTeams;
    }

    public void setFootballTeams(List<FootballTeam> footballTeams) {
        this.footballTeams = footballTeams;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoTour() {
        return logoTour;
    }

    public void setLogoTour(String logoTour) {
        this.logoTour = logoTour;
    }
}
