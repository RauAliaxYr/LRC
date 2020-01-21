package com.football.app.repos;

import com.football.app.model.FootballTournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentsRepo extends JpaRepository<FootballTournament,Long> {


    FootballTournament findById(long id);

    FootballTournament findByName(String name);

    FootballTournament findByIsActive(boolean isActive);

}
