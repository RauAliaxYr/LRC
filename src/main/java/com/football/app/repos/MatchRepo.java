package com.football.app.repos;


import com.football.app.model.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MatchRepo extends JpaRepository<FootballMatch,Long> {

   FootballMatch findById(long id);


}
