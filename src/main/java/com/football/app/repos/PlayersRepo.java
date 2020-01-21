package com.football.app.repos;

import com.football.app.model.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepo extends JpaRepository<FootballPlayer, Long> {

    FootballPlayer findById(long id);

    FootballPlayer findBySecName(String secName);

}
