package com.football.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class FootballTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String logo;

    private Integer win;
    private Integer draw;
    private Integer lose;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "footballTeams_match",
    joinColumns = {@JoinColumn(name = "team_id")},
    inverseJoinColumns = {@JoinColumn(name = "match_id")}
    )
    private List<FootballMatch> matches;

  @ManyToMany(mappedBy = "teams")
    private List<FootballPlayer> footballPlayers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "teamTournaments",
            joinColumns = {@JoinColumn(name = "footballTeam_id")},
            inverseJoinColumns = {@JoinColumn(name = "tournament_id")}
    )
  private List<FootballTournament> tournamentList;

    public FootballTeam(String name) {
        this.name = name;
    }

    public FootballTeam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public List<FootballPlayer> getFootballPlayers() {
        return footballPlayers;
    }

    public void setFootballPlayers(List<FootballPlayer> footballPlayers) {
        this.footballPlayers = footballPlayers;
    }
}
