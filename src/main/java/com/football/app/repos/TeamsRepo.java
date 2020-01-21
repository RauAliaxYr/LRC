package com.football.app.repos;

import com.football.app.model.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepo extends JpaRepository<FootballTeam,Long> {

    FootballTeam findByName(String name);

    FootballTeam findById(long id);


}
